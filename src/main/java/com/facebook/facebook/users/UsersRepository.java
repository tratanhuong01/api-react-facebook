package com.facebook.facebook.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query(value = "SELECT * FROM users WHERE users.email = ?1 OR users.phone = ?1 ",nativeQuery = true)
    List<Users> checkRegister(String emailOrPhone);

    @Query(value = "SELECT * FROM users WHERE id = ?1 ",nativeQuery = true)
    Users getUserById(Long id);

    @Query(value = "SELECT * FROM users WHERE (email = ?1 OR phone = ?1 ) AND password = ?2 ",nativeQuery = true)
    Users checkLogin(String emailOrPhone,String password);
}