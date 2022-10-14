package com.danarim.multithreading.service;

import com.danarim.multithreading.model.ContactInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private final Logger logger = LoggerFactory.getLogger(ContactInfoServiceImpl.class);

    @Override
    public List<ContactInfo> getAllContactInfos() {
        logger.info("Get All ContactInfo start");

        List<ContactInfo> resultList = new ArrayList<>();

        ContactInfo contactInfo1 = new ContactInfo();
        ContactInfo contactInfo2 = new ContactInfo();
        contactInfo1.setEmail("test@test");
        contactInfo1.setPhoneNumber("123456789");

        contactInfo2.setEmail("test1@test1");
        contactInfo2.setPhoneNumber("987654321");

        resultList.add(contactInfo1);
        resultList.add(contactInfo2);

        logger.info("Get All ContactInfo finish");
        return resultList;
    }
}
