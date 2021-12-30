package com.facebook.facebook.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100)
    String firstName;

    @Column(length = 100)
    String lastName;

    @Column(length = 100,unique = true)
    String email;

    @Column(length = 10,unique = true)
    String phone;

    @Column
    String password;

    @Column
    String gender;

    @Column
    Timestamp birthday;

    @Column
    String avatar;

    @Column
    String cover;

    @Column
    String description;

    @Column
    int isTick;

    @Column
    String codeEmail;

    @Column
    String codePhone;

    @Column
    Integer isOnline;

    @Column
    Integer isDark;

    @Column
    Timestamp timeCreated;

}
