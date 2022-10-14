package com.danarim.multithreading.controller;

import com.danarim.multithreading.model.Address;
import com.danarim.multithreading.model.ContactInfo;
import com.danarim.multithreading.model.Person;
import com.danarim.multithreading.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AsyncController {

    private final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    private final AsyncService asyncService;

    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/testAsync")
    public void testAsync() throws InterruptedException, ExecutionException {
        logger.info("testAsync started");
        long start = System.currentTimeMillis();

        CompletableFuture<List<Address>> addresses = asyncService.getAllAddresses();
        CompletableFuture<List<ContactInfo>> contactInfos = asyncService.getAllContactInfos();
        CompletableFuture<List<Person>> persons = asyncService.getAllPersons();

        CompletableFuture.allOf(addresses, contactInfos, persons).join();

        logger.info("Transaction time: " + (System.currentTimeMillis() - start));
        logger.info("Addresses--> " + addresses.get());
        logger.info("ContactInfos--> " + contactInfos.get());
        logger.info("Persons--> " + persons.get());
    }
}
