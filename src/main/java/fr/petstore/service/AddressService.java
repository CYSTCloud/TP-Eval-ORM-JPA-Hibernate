package fr.petstore.service;

import fr.petstore.dao.AddressDao;
import fr.petstore.model.Address;
import jakarta.persistence.EntityManager;

public class AddressService {
    private AddressDao addressDao;
    
    public AddressService(EntityManager em) {
        this.addressDao = new AddressDao(em);
    }
    
    public Address createAddress(String number, String street, String zipCode, String city) {
        Address address = new Address(number, street, zipCode, city);
        addressDao.create(address);
        return address;
    }
}
