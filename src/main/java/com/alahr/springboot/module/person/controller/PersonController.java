package com.alahr.springboot.module.person.controller;

import com.alahr.springboot.module.person.dto.Person;
import com.alahr.springboot.module.person.service.PersonService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @Value("${alahr.person.desc}")
    private String desc;

    @RequestMapping(value = "/")
    public String home(){
        return "This is the Person Model's Page, Welcome!";
    }

    @RequestMapping(value = "/findAll")
    public PageInfo<Person> findAll(@RequestParam(value = "pageNum", defaultValue = "1")int pageNum, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        logger.info("Person findAll method: pageNum-{}; pageSize-{}", pageNum, pageSize);
        return personService.findAll(pageNum, pageSize);
    }

    @RequestMapping(value = "/getById")
    public Person getById(@RequestParam(value = "id")BigInteger id){
        return personService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody Person person){
        return personService.add(person);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(@RequestBody Person person){
        return personService.update(person);
    }

    @RequestMapping(value = "/removeById")
    public int removeById(@RequestParam(value = "id")BigInteger id){
        return personService.removeById(id);
    }

    @RequestMapping(value = "/jsonStr", method = RequestMethod.POST)
    public String jsonStr(@RequestBody JSONObject json){
        logger.info("param from properties file:{}", desc);
        logger.info("json str: {}-{}", json.getString("name"), json.get("address"));
        return json.toJSONString();
    }
}
