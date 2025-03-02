package fr.petstore.dao;

import fr.petstore.model.Animal;
import jakarta.persistence.EntityManager;

public class AnimalDao {
    private EntityManager em;
    
    public AnimalDao(EntityManager em) {
        this.em = em;
    }
    
    public void create(Animal animal) {
        em.persist(animal);
    }
}
