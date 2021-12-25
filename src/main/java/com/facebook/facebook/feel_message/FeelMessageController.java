package com.facebook.facebook.feel_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/feelMessages")

public class FeelMessageController {

    //
    @Autowired
    FeelMessageService feelMessageService;
    //

    @PostMapping("")
    public FeelMessage addFeelMessage(@RequestBody FeelMessage feelMessage) {
        return feelMessageService.addFeelMessage(feelMessage);
    }

    @PutMapping("")
    public FeelMessage updateFeelMessage(@RequestBody FeelMessage feelMessage) {
        return feelMessageService.updateFeelMessage(feelMessage);
    }

    @DeleteMapping("")
    public void deleteFeelMessage(@RequestBody FeelMessage feelMessage) {
        feelMessageService.deleteFeelMessage(feelMessage);
    }


}
