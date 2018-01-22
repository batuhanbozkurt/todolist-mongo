package com.bozkurt.todolistmongo.service;


import com.bozkurt.todolistmongo.model.ListItem;

import java.util.List;

public interface ListItemService {
    void save(ListItem listItem);
    ListItem findById(String id);
    List<ListItem> findAll();
    void delete(String id);
}
