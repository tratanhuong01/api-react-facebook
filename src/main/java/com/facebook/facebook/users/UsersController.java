package com.facebook.facebook.users;

import com.facebook.facebook.dto.AccountLogin;
import com.facebook.facebook.dto.DataJWT;
import com.facebook.facebook.dto.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")

public class UsersController {

    //
    @Autowired
    UsersService usersService;
    //

    @GetMapping("")
    public Users getUserByIdOrToken(@RequestParam(required = false) Long id,@RequestParam(required = false) String token) {
        return usersService.getUserByIdOrToken(id,token);
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

    @PostMapping("/generate/jwt")
    public String generateJWT(@RequestBody DataJWT dataJWT) {
        return usersService.generateJWT(dataJWT);
    }

    @PostMapping("/generate/login/id/jwt")
    public UserDetail generateLoginByIdJWT(@RequestParam Long id) {
        return usersService.generateLoginByIdJWT(id);
    }

    @PostMapping("/check/register")
    public Users checkRegister(@RequestParam String emailOrPhone) {
        return usersService.checkRegister(emailOrPhone);
    }

    @PostMapping("/check/login")
    public UserDetail checkLogin(@RequestBody AccountLogin accountLogin) {
        return usersService.checkLogin(accountLogin);
    }

}
