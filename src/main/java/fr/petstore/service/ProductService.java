package fr.petstore.service;

import fr.petstore.dao.ProductDao;
import fr.petstore.model.PetStore;
import fr.petstore.model.ProdType;
import fr.petstore.model.Product;
import jakarta.persistence.EntityManager;

public class ProductService {
    private ProductDao productDao;
    
    public ProductService(EntityManager em) {
        this.productDao = new ProductDao(em);
    }
    
    public Product createProductForPetStore(String code, String label, ProdType type, double price, PetStore petStore) {
        Product product = new Product();
        product.setCode(code);
        product.setLabel(label);
        product.setType(type);
        product.setPrice(price);
        product.setPetStore(petStore);
        productDao.create(product);
        return product;
    }
}
