package com.facebook.facebook.messages;

import com.facebook.facebook.dto.MessageByGroup;
import com.facebook.facebook.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    public List<Messages> getMessageByIdGroupMessage(@RequestParam Long idGroupMessage,@RequestParam Integer offset,
                                                     @RequestParam Integer limit) {
        return messagesService.getMessageByIdGroupMessage(idGroupMessage,offset,limit);
    }

    @GetMapping("/getList")
    public List<MessageByGroup> getMessageByGroupByIdUser(@RequestParam Long idUser,@RequestParam Integer offset,
                                                          @RequestParam Integer limit) {
        return messagesService.getMessageByGroupByIdUser(idUser,offset,limit);
    }

    @GetMapping("/getUser")
    public List<Users> getUserByGroupMessage(@RequestParam Long idUser,@RequestParam String groupMessage) {
        return messagesService.getUserByGroupMessage(idUser,groupMessage);
    }


}
