package com.gzcb.impl;

import com.gzcb.Person;

public class PersonImpl implements Person {
    private String name;
    private String house;

    public PersonImpl(String name, String house) {
        this.name = name;
        this.house = house;
    }

    public void buy() {
        System.out.println(name+"买了"+house);
    }

    public void buy1() {
        System.out.println("做人要低调");
    }
}
