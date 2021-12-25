package com.facebook.facebook.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")

public class UsersController {

    //
    @Autowired
    UsersService usersService;
    //

    @GetMapping("")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping("")
    public Users addUser(@RequestBody Users users) {
        return usersService.addUser(users);
    }

    @PutMapping("")
    public Users updateUser(@RequestBody Users users) {
        return usersService.updateUser(users);
    }

    @DeleteMapping("")
    public void deleteUser(@RequestBody Users users) {
        usersService.deleteUser(users);
    }

}
