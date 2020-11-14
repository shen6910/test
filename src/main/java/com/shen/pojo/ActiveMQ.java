package com.shen.pojo;

import java.io.Serializable;

public class ActiveMQ implements Serializable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ActiveMQ() {}

    public ActiveMQ(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
