package com.danarim.multithreading.controller;

import com.danarim.multithreading.model.Address;
import com.danarim.multithreading.model.ContactInfo;
import com.danarim.multithreading.model.Person;
import com.danarim.multithreading.service.AddressService;
import com.danarim.multithreading.service.ContactInfoService;
import com.danarim.multithreading.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private final AddressService addressService;
    private final ContactInfoService contactInfoService;
    private final PersonService personService;

    @Autowired
    public DataController(AddressService addressService,
                          ContactInfoService contactInfoService,
                          PersonService personService) {
        this.addressService = addressService;
        this.contactInfoService = contactInfoService;
        this.personService = personService;
    }

    @GetMapping(value = "/addresses")
    public List<Address> getAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping(value = "/contactinfos")
    public List<ContactInfo> getContactInfos() {
        return contactInfoService.getAllContactInfos();
    }

    @GetMapping(value = "/persons")
    public List<Person> getPersons() {
        return personService.getAllPersons();
    }
}
