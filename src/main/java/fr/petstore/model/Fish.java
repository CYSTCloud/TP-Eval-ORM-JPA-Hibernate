package fr.petstore.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "Fish")
public class Fish extends Animal {
    
    @Enumerated(EnumType.STRING)
    @Column(name = "livingEnv")
    private FishLivEnv livingEnv;
    
    public Fish() {
    }
    
    public Fish(Date birthDate, String couleur, FishLivEnv livingEnv) {
        super(birthDate, couleur);
        this.livingEnv = livingEnv;
    }
    
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
