package fr.petstore.dao;

import fr.petstore.model.Product;
import jakarta.persistence.EntityManager;

public class ProductDao {
    private EntityManager em;
    
    public ProductDao(EntityManager em) {
        this.em = em;
    }
    
    public void create(Product product) {
        em.persist(product);
    }
}
