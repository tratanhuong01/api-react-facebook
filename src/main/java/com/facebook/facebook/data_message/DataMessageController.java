package com.facebook.facebook.data_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/dataMessages")

public class DataMessageController {

    @Autowired
    DataMessageService dataMessageService;

    @PostMapping("")
    public DataMessage addDataMessage(@RequestBody DataMessage dataMessage) {
        return dataMessageService.addDataMessage(dataMessage);
    }

    @PutMapping("")
    public DataMessage updateDataMessage(@RequestBody DataMessage dataMessage) {
        return dataMessageService.updateDataMessage(dataMessage);
    }

    @DeleteMapping("")
    public void deleteDataMessage(@RequestBody DataMessage dataMessage) {
        dataMessageService.deleteDataMessage(dataMessage);
    }

}
