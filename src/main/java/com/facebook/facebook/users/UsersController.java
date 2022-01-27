package com.facebook.facebook.users;

import com.facebook.facebook.dto.AccountLogin;
import com.facebook.facebook.dto.DataJWT;
import com.facebook.facebook.dto.UserDetail;
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

    @GetMapping("/id")
    public Users getUserById(@RequestParam(required = false) Long id) {
        return usersService.getUserById(id);
    }

    @GetMapping("/token")
    public UserDetail getUserByToken(@RequestParam(required = false) String token) {
        return usersService.getUserByToken(token);
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

    @GetMapping("/online")
    public List<Users> getUserFriendOnlineByIdUser(@RequestParam Long idUser,@RequestParam Integer offset,
                                                   @RequestParam Integer limit) {
        return usersService.getUserFriendOnlineByIdUser(idUser,offset,limit);
    }

    @GetMapping("/tint")
    public List<Users> getTintUserByIdUser(@RequestParam Long idUser,@RequestParam Long idView) {
        return usersService.getTintUserByIdUser(idUser,idView);
    }

}
