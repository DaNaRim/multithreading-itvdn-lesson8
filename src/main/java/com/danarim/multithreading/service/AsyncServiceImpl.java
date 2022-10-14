package com.danarim.multithreading.service;

import com.danarim.multithreading.model.Address;
import com.danarim.multithreading.model.ContactInfo;
import com.danarim.multithreading.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.danarim.multithreading.AsyncConfiguration.EXECUTOR_NAME;

@Service
public class AsyncServiceImpl implements AsyncService {

    private final RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Autowired
    public AsyncServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async(EXECUTOR_NAME)
    @Override
    @SuppressWarnings("unchecked")
    public CompletableFuture<List<Address>> getAllAddresses() throws InterruptedException {
        logger.info("getAllAddresses started");

        List<Address> addressList = restTemplate.getForObject("http://localhost:8080/addresses", List.class);

        logger.info("Addresses: {}", addressList);
        Thread.sleep(1000);
        logger.info("getAllAddresses finished");
        return CompletableFuture.completedFuture(addressList);
    }

    @Async(EXECUTOR_NAME)
    @Override
    @SuppressWarnings("unchecked")
    public CompletableFuture<List<ContactInfo>> getAllContactInfos() throws InterruptedException {
        logger.info("getAllContactInfos started");

        List<ContactInfo> contactInfos = restTemplate.getForObject("http://localhost:8080/contactinfos", List.class);

        logger.info("ContactInfo: {}", contactInfos);
        Thread.sleep(1000);
        logger.info("getAllContactInfos finished");
        return CompletableFuture.completedFuture(contactInfos);
    }

    @Async(EXECUTOR_NAME)
    @Override
    @SuppressWarnings("unchecked")
    public CompletableFuture<List<Person>> getAllPersons() throws InterruptedException {
        logger.info("getAllPersons started");

        List<Person> personList = restTemplate.getForObject("http://localhost:8080/persons", List.class);

        logger.info("Person: {}", personList);
        Thread.sleep(1000);
        logger.info("getAllPersons finished");
        return CompletableFuture.completedFuture(personList);
    }
}
