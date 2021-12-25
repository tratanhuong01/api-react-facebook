package com.facebook.facebook.feel_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class FeelMessageService {

    //
    @Autowired
    FeelMessageRepository feelMessageRepository;
    //

    public FeelMessage addFeelMessage(FeelMessage feelMessage) {
        feelMessage.setTimeCreated(new Timestamp(new Date().getTime()));
        return feelMessageRepository.save(feelMessage);
    }

    public FeelMessage updateFeelMessage(FeelMessage feelMessage) {
        return feelMessageRepository.save(feelMessage);
    }

    public void deleteFeelMessage(FeelMessage feelMessage) {
        feelMessageRepository.delete(feelMessage);
    }

}
