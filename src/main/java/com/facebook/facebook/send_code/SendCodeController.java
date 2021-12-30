package com.facebook.facebook.send_code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController

public class SendCodeController {

    //
    @Autowired
    SendCodeService sendCodeService;
    //

    @PostMapping("send/code/email")
    public Integer sendCodeEmail(@RequestParam String email,@RequestParam(required = false) Integer typeSend) {
        return sendCodeService.sendCodeMail(email);
    }

    @PostMapping("send/code/phone")
    public Integer sendCodePhone(@RequestParam String phone,@RequestParam(required = false) Integer typeSend) {
        return sendCodeService.sendCodePhone(phone);
    }


}
