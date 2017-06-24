package edu.lyon1.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class TweetController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @RequestMapping("/count")
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from tweets", Integer.class);
    }

    @RequestMapping("/list")
    public List<Tweet> list(@RequestParam(name = "auteur", required = false) Optional<String> auteur) {
        return auteur
                .map(a -> tweetRepository.findAllByAuteurOrderByDateDesc(a))
                .orElseGet(() -> tweetRepository.findAllByOrderByDateDesc());
    }

    @RequestMapping("/tweet")
    public int tweet(@RequestParam("auteur") Utilisateur auteur, @RequestParam("contenu") String contenu) {
        Tweet newTweet = new Tweet(contenu, auteur);
        tweetRepository.save(newTweet);
        System.out.println(tweetRepository.findFirstByOrderByIdDesc());
        return tweetRepository.findFirstByOrderByIdDesc().getId();
    }

    @RequestMapping("/utilisateurs")
    public Iterable<Utilisateur> utilisateurs() {
        return utilisateurRepository.findAll();
    }

    @RequestMapping("/retweet")
    public ResponseEntity retweet(@RequestParam("utilisateur") String utilisateur, @RequestParam("tweet") Integer id) {
        Tweet tweet = tweetRepository.findOne(id);
        if (tweet.getAuteur().equals(utilisateur)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        tweet.getRetweeters().add(utilisateurRepository.findOne(utilisateur));
        try {
            tweetRepository.save(tweet);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/tweet/{id}")
    public Tweet detailedTweet(@PathVariable("id") Integer id) {
        return tweetRepository.findOne(id);
    }

    @RequestMapping("/follow/{follower}/{followee}")
    public void follow(@PathVariable("follower") String followerHandle, @PathVariable("followee") String followeeHandle) {
        Utilisateur follower = utilisateurRepository.findByHandle(followerHandle);
        Utilisateur followee = utilisateurRepository.findByHandle(followeeHandle);

        follower.getFollowees().add(followee);
        utilisateurRepository.save(follower);
    }

}
