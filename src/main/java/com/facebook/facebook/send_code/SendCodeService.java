package com.facebook.facebook.send_code;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service

public class SendCodeService {

    @Autowired
    JavaMailSender javaMailSender;

    public static final String ACCOUNT_SID = "AC17c314b390c0dfc4cb9ea4bcd18fbb36";
    public static final String AUTH_TOKEN = "d743a584f94fa3f47202919494c0d9f4";

    public String sendCodePhone(String phone,String code) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phone),
                        new com.twilio.type.PhoneNumber("+17163254968"),
                        code )
                .create();
        return message.getSid();
    }

    public SendCodeModel sendCodeModelMail(SendCodeModel sendCodeModel) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            messageHelper.setFrom("Facebook");
            messageHelper.setTo(sendCodeModel.getEmailOrPhone());
            messageHelper.setSubject(sendCodeModel.getTopic());
            messageHelper.setText("",true);
            javaMailSender.send(mimeMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sendCodeModel;
    }



}
