package com.bozkurt.todolistmongo.dto;

public class AddItemDto {
    String itemText;

    public AddItemDto() {
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }
}
