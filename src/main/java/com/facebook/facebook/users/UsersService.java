package com.facebook.facebook.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service

public class UsersService {

    //
    @Autowired
    UsersRepository usersRepository;
    //

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users addUser(Users users) {
        users.setTimeCreated(new Timestamp(new Date().getTime()));
        return usersRepository.save(users);
    }

    public Users updateUser(Users users) {
        return usersRepository.save(users);
    }

    public void deleteUser(Users users) {
        usersRepository.delete(users);
    }

}
