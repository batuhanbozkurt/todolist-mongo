package com.bozkurt.todolistmongo.dto;

public class DeleteItemDto {
    String itemId;

    public DeleteItemDto(){}

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
