package com.bozkurt.todolistmongo.model;

import java.util.UUID;

public class ListItem {

    private String id;

    private String text;

    private String status;

    public ListItem(){
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
