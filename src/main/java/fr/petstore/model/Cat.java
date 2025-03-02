package fr.petstore.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cat")
public class Cat extends Animal {
    
    @Column(name = "chipId")
    private String chipId;
    
    public Cat() {
    }
    
    public Cat(Date birthDate, String couleur, String chipId) {
        super(birthDate, couleur);
        this.chipId = chipId;
    }
    
    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
