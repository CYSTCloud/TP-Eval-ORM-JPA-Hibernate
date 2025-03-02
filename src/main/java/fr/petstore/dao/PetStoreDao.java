package fr.petstore.dao;

import fr.petstore.model.Animal;
import fr.petstore.model.PetStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PetStoreDao {
    private EntityManager em;
    
    public PetStoreDao(EntityManager em) {
        this.em = em;
    }
    
    public void create(PetStore petStore) {
        em.persist(petStore);
    }
    
    public PetStore findById(Long id) {
        return em.find(PetStore.class, id);
    }
    
    public List<Animal> findAllAnimals(Long petStoreId) {
        TypedQuery<Animal> query = em.createQuery(
            "SELECT a FROM Animal a WHERE a.petStore.id = :id", 
            Animal.class
        );
        query.setParameter("id", petStoreId);
        return query.getResultList();
    }
}
