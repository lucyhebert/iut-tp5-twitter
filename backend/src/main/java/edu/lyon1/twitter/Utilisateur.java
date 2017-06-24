package edu.lyon1.twitter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;

@Entity(name = "utilisateurs")
public class Utilisateur implements Serializable {
    @Id
    private String handle;
    private Timestamp inscription;
    private String prenom;
    private String nom;
    @ManyToMany
    @JoinTable(
            name="follows",
            joinColumns = @JoinColumn( name="handle"),
            inverseJoinColumns = @JoinColumn( name="follower")
    )
    @JsonIgnore
    private Collection<Utilisateur> followers;
    @ManyToMany
    @JoinTable(
            name="follows",
            joinColumns = @JoinColumn( name="handle"),
            inverseJoinColumns = @JoinColumn( name="followee")
    )
    @JsonIgnore
    private Collection<Utilisateur> followees;

    public Utilisateur(String handle, Timestamp inscription, String prenom, String nom) {
        this.handle = handle;
        this.inscription = inscription;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Utilisateur() {
    }

    public String getHandle() {
        return handle;
    }

    public Timestamp getInscription() {
        return inscription;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public void setInscription(Timestamp inscription) {
        this.inscription = inscription;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Utilisateur> getFollowers() {
        return followers;
    }

    public void setFollowers(Collection<Utilisateur> followers) {
        this.followers = followers;
    }

    public Collection<Utilisateur> getFollowees() {
        return followees;
    }

    public void setFollowees(Collection<Utilisateur> followees) {
        this.followees = followees;
    }
}
