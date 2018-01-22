package com.bozkurt.todolistmongo.repository;

import com.bozkurt.todolistmongo.model.ListItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListItemRepository extends MongoRepository<ListItem, String> {
}
