package com.danarim.multithreading.service;

import com.danarim.multithreading.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    public List<Person> getAllPersons() {
        logger.info("Get All Person start");

        List<Person> resultList = new ArrayList<>();

        Person person1 = new Person();
        Person person2 = new Person();

        person1.setFirstName("TestFistName");
        person1.setSecondName("TestSecondName");
        person1.setAge(20);

        person2.setFirstName("Test1FistName");
        person2.setSecondName("Test1SecondName");
        person2.setAge(30);

        resultList.add(person1);
        resultList.add(person2);

        logger.info("Get All Person finish");
        return resultList;
    }
}
