package com.facebook.facebook.send_code;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service

public class SendCodeService {

    @Autowired
    JavaMailSender javaMailSender;

    public static final String ACCOUNT_SID = "AC17c314b390c0dfc4cb9ea4bcd18fbb36";
    public static final String AUTH_TOKEN = "d743a584f94fa3f47202919494c0d9f4";

    public Integer randomNumber() {
        Random rnd = new Random();
        return rnd.nextInt(9999999);
    }

    public Integer sendCodePhone(String phone) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Integer code = randomNumber();
        try {
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber(phone),
                            new com.twilio.type.PhoneNumber("+17163254968"),
                            code.toString())
                    .create();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return code;
    }

    public Integer sendCodeMail(String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        Integer code = randomNumber();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            messageHelper.setFrom("Facebook");
            messageHelper.setTo(email);
            messageHelper.setSubject("Facebook Application");
            messageHelper.setText("Code verify : " + code,true);
            javaMailSender.send(mimeMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return code;
    }



}
