package com.example.springboot.controller;

import com.example.springboot.model.Person;
import com.example.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Person> getAccounts(){
        return personService.findAccountList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Person getAccountById(@PathVariable("id") int id){
        return personService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "age" ,required = true)int age){
        Person account=new Person();
        account.setAge(age);
        account.setName(name);
        account.setId(id);
        int t=personService.update(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "age" )int age){
        Person person=new Person();
        person.setAge(age);
        person.setName(name);
        int t= personService.add(person);
        if(t==1){
            return person.toString();
        }else {
            return "fail";
        }

    }

}
