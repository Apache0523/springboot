package com.example.springboot.controller;

import com.example.springboot.model.ConfigBean;
import com.example.springboot.model.TestBean;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class BeanController {
    @Autowired
    ConfigBean configBean;

    @RequestMapping(value="/bean")
    public String beanTest(){
        return configBean.getGreeting()+" >>>>"+configBean.getNumber()+">>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax()+">>>"+configBean.getValue();
    }

    @Autowired
    TestBean user;
    @RequestMapping(value = "/test")
    public String user(){
        return user.getName()+":"+user.getAge();
    }

}
