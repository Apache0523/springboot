package com.example.springboot.dao.daoImpl;

import com.example.springboot.dao.PersonDao;
import com.example.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(Person person) {
        return jdbcTemplate.update("insert into person(name, age) values(?, ?)",
                person.getName(),person.getAge());

    }

    @Override
    public int update(Person person) {
        return jdbcTemplate.update("UPDATE  person SET name=? ,age=? WHERE id=?",
                person.getName(),person.getAge(),person.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE person where id=?",id);
    }

    @Override
    public Person findAccountById(int id) {
        List<Person> list = jdbcTemplate.query("select * from person where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Person.class));
        if(list!=null && list.size()>0){
            Person person = list.get(0);
            return person;
        }else{
            return null;
        }
    }

    @Override
    public List<Person> findAccountList() {
        List<Person> list = jdbcTemplate.query("select * from person", new Object[]{}, new BeanPropertyRowMapper(Person.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}


