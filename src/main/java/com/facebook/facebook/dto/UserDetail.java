package com.facebook.facebook.dto;

import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDetail {

    Users users;
    String token;
    Integer status;

}
