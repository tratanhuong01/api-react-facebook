package com.facebook.facebook.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class MessagesService {

    //
    @Autowired
    MessagesRepository messagesRepository;
    //

    public Messages addMessage(Messages messages) {
        messages.setTimeCreated(new Timestamp(new Date().getTime()));
        return messagesRepository.save(messages);
    }

    public Messages updateMessage(Messages messages) {
        return messagesRepository.save(messages);
    }

    public void deleteMessage(Messages messages) {
        messagesRepository.delete(messages);
    }

}
