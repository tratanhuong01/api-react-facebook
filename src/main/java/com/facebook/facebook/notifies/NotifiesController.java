package com.facebook.facebook.notifies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/notifies")

public class NotifiesController {

    @Autowired
    NotifiesService notifiesService;

}
