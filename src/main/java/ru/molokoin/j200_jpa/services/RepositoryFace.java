package ru.molokoin.j200_jpa.services;

import java.util.List;

import jakarta.ejb.Local;
import ru.molokoin.j200_jpa.entities.Domains;
import ru.molokoin.j200_jpa.entities.Person;

@Local
public interface RepositoryFace {
    boolean checkUser(String username, String password);
    
    List<Person> getAllPerson();
    
    Person createPerson(Person person);
    
    Domains createDomains(Domains domain);
    
    void updateDomains(Domains domain);
}
