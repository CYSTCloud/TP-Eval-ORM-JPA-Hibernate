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
import fr.petstore.service.AddressService;
import fr.petstore.service.AnimalService;
import fr.petstore.service.PetStoreService;
import fr.petstore.service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    
    public static void main(String[] args) {
        // Initialisation JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        // Services
        PetStoreService petStoreService = new PetStoreService(em);
        AddressService addressService = new AddressService(em);
        ProductService productService = new ProductService(em);
        AnimalService animalService = new AnimalService(em);
        
        // Création animalerie
        Address address = addressService.createAddress("10", "Rue Paris", "75001", "Paris");
        PetStore petStore = petStoreService.createPetStoreWithAddress("PetStore Paris", "Jean", address);
        
        // Création produits
        productService.createProductForPetStore("FOOD001", "Croquettes premium", ProdType.FOOD, 29.99, petStore);
        productService.createProductForPetStore("ACC001", "Jouet pour chat", ProdType.ACCESSORY, 12.50, petStore);
        productService.createProductForPetStore("CLEAN001", "Nettoyant aquarium", ProdType.CLEANING, 8.75, petStore);
        
        // Création animaux
        Cat cat1 = animalService.createCat(new Date(), "Noir", "CHIP001");
        Cat cat2 = animalService.createCat(new Date(), "Blanc", "CHIP002");
        Fish fish1 = animalService.createFish(new Date(), "Rouge", FishLivEnv.FRESH_WATER);
        
        // Association animaux-animalerie
        petStoreService.addAnimalToPetStore(petStore, cat1);
        petStoreService.addAnimalToPetStore(petStore, cat2);
        petStoreService.addAnimalToPetStore(petStore, fish1);
        
        tx.commit();
        
        // Affichage des animaux
        System.out.println("Liste des animaux dans l'animalerie " + petStore.getName() + ":");
        List<Animal> animals = petStoreService.getAllAnimalsInPetStore(petStore.getId());
        
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println("Chat: " + cat.getCouleur() + " - Puce: " + cat.getChipId());
            } else if (animal instanceof Fish) {
                Fish fish = (Fish) animal;
                System.out.println("Poisson: " + fish.getCouleur() + " - Environnement: " + fish.getLivingEnv());
            }
        }
        
        // Fermeture des ressources
        em.close();
        emf.close();
    }
}
