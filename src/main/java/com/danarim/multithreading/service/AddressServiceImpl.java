package com.danarim.multithreading.service;

import com.danarim.multithreading.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Override
    public List<Address> getAllAddresses() {
        logger.info("Get All Address start");

        List<Address> resultList = new ArrayList<>();

        Address address1 = new Address();
        Address address2 = new Address();
        address1.setStreet("Test1");
        address1.setHouse("Test1");
        address1.setCity("Test1");
        address1.setZipCode(10000);

        address2.setStreet("Test2");
        address2.setHouse("Test2");
        address2.setCity("Test2");
        address2.setZipCode(20000);

        resultList.add(address1);
        resultList.add(address2);

        logger.info("Get All Address finish");

        return resultList;
    }
}
