package com.facebook.facebook.group_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/groupMessages")

public class GroupMessageController {

    //
    @Autowired
    GroupMessageService groupMessageService;
    //

    @PostMapping("")
    public GroupMessage addGroupMessage(@RequestBody GroupMessage groupMessage) {
        return groupMessageService.addGroupMessage(groupMessage);
    }

    @PutMapping("")
    public GroupMessage updateGroupMessage(@RequestBody GroupMessage groupMessage) {
        return groupMessageService.updateGroupMessage(groupMessage);
    }

    @DeleteMapping("")
    public void deleteGroupMessage(@RequestBody GroupMessage groupMessage) {
        groupMessageService.deleteGroupMessage(groupMessage);
    }

}
