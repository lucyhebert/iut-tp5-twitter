package edu.lyon1.twitter;

import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,String> {

    Utilisateur findByHandle(String handle);
}
