package com.facebook.facebook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateNickname {

    String content;
    Long idGroupMessage;
    Long idUser;
    Integer typeMessage;

}
