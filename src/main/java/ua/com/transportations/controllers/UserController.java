package ua.com.transportations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public User addUser(User userDto) {
        return uService.registerUser(userDto);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public User getUser(@PathVariable("id") long userId) {
        return uService.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(User userDto) {
        return userDto;
    }

}
