package fr.petstore.dao;

import fr.petstore.model.Address;
import jakarta.persistence.EntityManager;

public class AddressDao {
    private EntityManager em;
    
    public AddressDao(EntityManager em) {
        this.em = em;
    }
    
    public void create(Address address) {
        em.persist(address);
    }
}
