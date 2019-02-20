package com.example.springboot.service;

import com.example.springboot.model.Person;

import java.util.List;

public interface PersonService {
    int add(Person person);

    int update(Person person);

    int delete(int id);

    Person findAccountById(int id);

    List<Person> findAccountList();

}
