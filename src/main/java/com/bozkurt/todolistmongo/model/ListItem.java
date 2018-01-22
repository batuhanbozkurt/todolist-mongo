package com.bozkurt.todolistmongo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;

public class ListItem {
    @Id
    private String id;

    @JsonBackReference
    public UserList userList;

    private String text;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
