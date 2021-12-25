package com.facebook.facebook.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/messages")

public class MessagesController {

    //
    @Autowired
    MessagesService messagesService;
    //

    @PostMapping("")
    public Messages addMessage(@RequestBody Messages messages) {
        return messagesService.addMessage(messages);
    }

    @PutMapping("")
    public Messages updateMessage(@RequestBody Messages messages) {
        return messagesService.updateMessage(messages);
    }

    @DeleteMapping("")
    public void deleteMessage(@RequestBody Messages messages) {
        messagesService.deleteMessage(messages);
    }


}
