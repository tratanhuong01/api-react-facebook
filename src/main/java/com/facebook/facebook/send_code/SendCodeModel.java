package com.facebook.facebook.send_code;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SendCodeModel {

    private String emailOrPhone;
    private Integer typeSendCode;
    private String topic;
    private String code;
}
