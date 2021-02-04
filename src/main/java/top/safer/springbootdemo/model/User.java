package top.safer.springbootdemo.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private int age;

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public User(){

    }
}
