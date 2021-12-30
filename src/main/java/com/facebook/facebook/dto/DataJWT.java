package com.facebook.facebook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DataJWT {

    String id;
    String emailOrPhone;
    String type;
    Long time;
    String code;

}
