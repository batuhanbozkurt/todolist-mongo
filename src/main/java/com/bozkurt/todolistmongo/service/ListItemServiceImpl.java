package com.bozkurt.todolistmongo.service;

import com.bozkurt.todolistmongo.model.ListItem;
import com.bozkurt.todolistmongo.repository.ListItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListItemServiceImpl implements ListItemService {

    final ListItemRepository listItemRepository;

    ListItemServiceImpl(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    @Override
    public void save(ListItem listItem) {
        listItemRepository.save(listItem);
    }

    @Override
    public ListItem findById(String id) {
        return listItemRepository.findOne(id);
    }

    @Override
    public List<ListItem> findAll() {
        return (List) listItemRepository.findAll();
    }

    @Override
    public void delete(String id) {
        listItemRepository.delete(id);
    }
}
