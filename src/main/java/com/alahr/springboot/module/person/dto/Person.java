package com.alahr.springboot.module.person.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.math.BigInteger;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private String card;
    private String name;
    private String birthday;
    private String gender;
    private String address;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
