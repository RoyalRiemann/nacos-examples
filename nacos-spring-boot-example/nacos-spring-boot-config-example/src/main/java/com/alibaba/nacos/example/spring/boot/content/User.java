package com.alibaba.nacos.example.spring.boot.content;

import java.io.Serializable;

/**
 * @author ligm
 * @version 1.0
 * @date 2022/2/21 0:20
 */

public class User implements Serializable {

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

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
