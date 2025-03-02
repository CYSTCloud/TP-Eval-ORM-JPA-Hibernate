package fr.petstore.service;

import fr.petstore.dao.AnimalDao;
import fr.petstore.model.Cat;
import fr.petstore.model.Fish;
import fr.petstore.model.FishLivEnv;
import jakarta.persistence.EntityManager;
import java.util.Date;

public class AnimalService {
    private AnimalDao animalDao;
    
    public AnimalService(EntityManager em) {
        this.animalDao = new AnimalDao(em);
    }
    
    public Cat createCat(Date birthDate, String couleur, String chipId) {
        Cat cat = new Cat(birthDate, couleur, chipId);
        animalDao.create(cat);
        return cat;
    }
    
    public Fish createFish(Date birthDate, String couleur, FishLivEnv livingEnv) {
        Fish fish = new Fish(birthDate, couleur, livingEnv);
        animalDao.create(fish);
        return fish;
    }
}
