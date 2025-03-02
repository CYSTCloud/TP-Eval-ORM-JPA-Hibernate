package fr.petstore.service;

import fr.petstore.dao.PetStoreDao;
import fr.petstore.model.Address;
import fr.petstore.model.Animal;
import fr.petstore.model.PetStore;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PetStoreService {
    private PetStoreDao petStoreDao;
    
    public PetStoreService(EntityManager em) {
        this.petStoreDao = new PetStoreDao(em);
    }
    
    public PetStore createPetStoreWithAddress(String name, String managerName, Address address) {
        PetStore petStore = new PetStore(name, managerName);
        petStore.setAddress(address);
        address.setPetStore(petStore);
        petStoreDao.create(petStore);
        return petStore;
    }
    
    public void addAnimalToPetStore(PetStore petStore, Animal animal) {
        animal.setPetStore(petStore);
        petStore.getAnimals().add(animal);
    }
    
    public List<Animal> getAllAnimalsInPetStore(Long petStoreId) {
        return petStoreDao.findAllAnimals(petStoreId);
    }
}
