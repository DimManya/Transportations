package ua.com.transportations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import ua.com.transportations.models.db.User;
import ua.com.transportations.services.UserService;

/**
 * Created by d.fedorov on 05.06.16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService uService;

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User userDto) {
        return uService.registerUser(userDto);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public User getUser(@PathVariable("id") long userId) {
        return uService.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public User update(@RequestBody User userDto) {
        return userDto;
    }

}
