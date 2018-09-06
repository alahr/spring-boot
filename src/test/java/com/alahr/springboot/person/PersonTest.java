package com.alahr.springboot.person;

import com.alahr.springboot.person.dto.Person;
import com.alahr.springboot.person.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonTest {
    private Logger logger = LoggerFactory.getLogger(PersonTest.class);

    @Autowired
    private PersonService personService;

    @Test
    public void test(){
        BigInteger id = BigInteger.valueOf(1L);
        Person person = personService.getById(id);
        logger.info("Person name={}, gender={}", person.getName(), person.getGender());
    }

    @Before
    public void before(){
        logger.info("------------before--------------");
    }

    @After
    public void after(){
        logger.info("------------after--------------");
    }
}
