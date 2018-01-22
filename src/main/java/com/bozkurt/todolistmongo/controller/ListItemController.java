package com.bozkurt.todolistmongo.controller;

import com.bozkurt.todolistmongo.dto.AddItemDto;
import com.bozkurt.todolistmongo.dto.DeleteItemDto;
import com.bozkurt.todolistmongo.model.ListItem;
import com.bozkurt.todolistmongo.model.User;
import com.bozkurt.todolistmongo.service.ListItemService;
import com.bozkurt.todolistmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListItemController {

    @Autowired
    private ListItemService listItemService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listItem", method = RequestMethod.POST)
    public ResponseEntity<ListItem> addItem(Model model, @RequestBody AddItemDto addItemDto) {

        User user = userService.findById("");

        ListItem listItem = new ListItem();
        listItem.setText(addItemDto.getItemText());
        listItem.setStatus("ACTIVE");
        listItem.setUserList(user.getUserLists().get(0));

        listItemService.save(listItem);

        return new ResponseEntity<ListItem>(listItem, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/listItem", method = RequestMethod.DELETE)
    public ResponseEntity removeItem(Model model, @RequestBody DeleteItemDto deleteItemDto) {

        listItemService.delete(deleteItemDto.getItemId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
