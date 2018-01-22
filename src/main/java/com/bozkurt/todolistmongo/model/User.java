package com.bozkurt.todolistmongo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

//@Document(collection = "users")
public class User {
    public User(){
    }

    @Id
    private String id;

    private String name;

    private String surname;

    private String email;

    @JsonIgnore
    private String password;

    private List<UserList> userLists = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserList> getUserLists() {
        return userLists;
    }

    public void setUserLists(List<UserList> userLists) {
        this.userLists = userLists;
    }
}
