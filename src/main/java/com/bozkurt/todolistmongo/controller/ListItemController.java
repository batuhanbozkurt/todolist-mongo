package com.bozkurt.todolistmongo.controller;

import com.bozkurt.todolistmongo.dto.AddItemDto;
import com.bozkurt.todolistmongo.model.ListItem;
import com.bozkurt.todolistmongo.model.User;
import com.bozkurt.todolistmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListItemController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listItem", method = RequestMethod.POST)
    public ResponseEntity<ListItem> addItem(Model model, @RequestBody AddItemDto addItemDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        ListItem item = new ListItem();
        item.setText(addItemDto.getItemText());
        item.setStatus("ACTIVE");
        user.getItems().add(item);

        userService.save(user);
        return new ResponseEntity<ListItem>(item, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/listItem/{listItemId}", method = RequestMethod.DELETE)
    public ResponseEntity removeItem(Model model, @PathVariable String listItemId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        user.getItems().removeIf(item -> item.getId().equals(listItemId));
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
