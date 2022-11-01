package com.glsic.cabinetmedical.controller;

import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.UserRepository;
import com.glsic.cabinetmedical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/USER")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);


    }

    @GetMapping("/AllUsers")
    public List<User> retrieveAllUsers() {
        List<User> list = userService.getAllUser();
        return list;

    }

    @GetMapping("/byid/{user_id}")
    public Optional<User> getById(@PathVariable("user_id") int user_id) {
        Optional<User> list = userService.getById(user_id);
        return list;

    }

    @DeleteMapping("/remove-User/{user_id}")
    public void removeUser(@PathVariable("user_id") int user_id) {
        userService.deleteUserById(user_id);

    }
        @PutMapping("/modify-User/{user_id}")
        public User modifyFurniture(@RequestBody User user,@PathVariable("user_id")int user_id) {
            return userService.updateUser(user, user_id);
        }




    }
