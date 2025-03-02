package fr.petstore.app;

import java.util.Date;
import java.util.List;

import fr.petstore.model.Address;
import fr.petstore.model.Animal;
import fr.petstore.model.Cat;
import fr.petstore.model.Fish;
import fr.petstore.model.FishLivEnv;
import fr.petstore.model.PetStore;
import fr.petstore.model.ProdType;
import fr.petstore.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        // On crée notre animalerie de ouf avec son adresse
        PetStore ps1 = new PetStore("PetStore Paris", "Jean");
        Address a1 = new Address("10", "Rue Paris", "75001", "Paris");
        ps1.setAddress(a1);
        a1.setPetStore(ps1);
        em.persist(ps1);
        
        // D'autres animaleries si t'en veux plus
        /* 
        PetStore ps2 = new PetStore("PetStore Lyon", "Marie");
        Address a2 = new Address("20", "Rue Lyon", "69001", "Lyon");
        ps2.setAddress(a2);
        a2.setPetStore(ps2);
        em.persist(ps2);
        
        PetStore ps3 = new PetStore("PetStore Marseille", "Pierre");
        Address a3 = new Address("30", "Rue Marseille", "13001", "Marseille");
        ps3.setAddress(a3);
        a3.setPetStore(ps3);
        em.persist(ps3);
        */
        
        // Ajout de quelques produits à vendre
        Product p1 = new Product("F001", "Croquettes", ProdType.FOOD);
        p1.setPetStore(ps1);
        em.persist(p1);
        
        Product p2 = new Product("A001", "Jouet", ProdType.ACCESSORY);
        p2.setPetStore(ps1);
        em.persist(p2);
        
        Product p3 = new Product("C001", "Shampoing", ProdType.CLEANING);
        p3.setPetStore(ps1);
        em.persist(p3);
        
        // D'autres produits si besoin
        /*
        Product p4 = new Product("F002", "Pâtée", ProdType.FOOD);
        p4.setPetStore(ps1);
        em.persist(p4);
        
        Product p5 = new Product("A002", "Cage", ProdType.ACCESSORY);
        p5.setPetStore(ps1);
        em.persist(p5);
        
        Product p6 = new Product("C002", "Brosse", ProdType.CLEANING);
        p6.setPetStore(ps1);
        em.persist(p6);
        */
        
        // On met quelques chats trop mignons
        Cat c1 = new Cat(new Date(), "Noir", "C123");
        c1.setPetStore(ps1);
        em.persist(c1);
        
        Cat c2 = new Cat(new Date(), "Blanc", "C456");
        c2.setPetStore(ps1);
        em.persist(c2);
        
        // Un chat en plus si tu veux
        /*
        Cat c3 = new Cat(new Date(), "Roux", "C789");
        c3.setPetStore(ps1);
        em.persist(c3);
        */
        
        // Et un poisson rouge (enfin bleu)
        Fish f1 = new Fish(new Date(), "Bleu", FishLivEnv.FRESH_WATER);
        f1.setPetStore(ps1);
        em.persist(f1);
        
        // D'autres poissons pour l'aquarium
        /*
        Fish f2 = new Fish(new Date(), "Rouge", FishLivEnv.SEA_WATER);
        f2.setPetStore(ps1);
        em.persist(f2);
        
        Fish f3 = new Fish(new Date(), "Jaune", FishLivEnv.FRESH_WATER);
        f3.setPetStore(ps1);
        em.persist(f3);
        */
        
        tx.commit();
        
        // On récup tous les animaux de notre animalerie
        Query q = em.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :id");
        q.setParameter("id", ps1.getId());
        List<Animal> animals = q.getResultList();
        
        System.out.println("Animaux de l'animalerie:");
        for (Animal a : animals) {
            System.out.println(a.getClass().getSimpleName());
            System.out.println(a.getCouleur());
        }
        
        em.close();
        emf.close();
    }
}
