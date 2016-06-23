package ua.com.transportations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.transportations.model.User;
import ua.com.transportations.services.UserService;

/**
 * Created by d.fedorov on 05.06.16.
 */
@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserService uService;

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(User userDto) {
        return userDto;

    }
}
