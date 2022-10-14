package com.danarim.multithreading.service;

import com.danarim.multithreading.model.Address;
import com.danarim.multithreading.model.ContactInfo;
import com.danarim.multithreading.model.Person;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncService {

    CompletableFuture<List<Address>> getAllAddresses() throws InterruptedException;

    CompletableFuture<List<ContactInfo>> getAllContactInfos() throws InterruptedException;

    CompletableFuture<List<Person>> getAllPersons() throws InterruptedException;
}
