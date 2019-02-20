package com.example.springboot.service.serviceImpl;

import com.example.springboot.dao.PersonDao;
import com.example.springboot.model.Person;
import com.example.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonDao personDao;
    @Override
    public int add(Person person) {
        return personDao.add(person);
    }

    @Override
    public int update(Person person) {
        return personDao.update(person);
    }

    @Override
    public int delete(int id) {
        return personDao.delete(id);
    }

    @Override
    public Person findAccountById(int id) {
        return personDao.findAccountById(id);
    }

    @Override
    public List<Person> findAccountList() {
        return personDao.findAccountList();
    }

}
