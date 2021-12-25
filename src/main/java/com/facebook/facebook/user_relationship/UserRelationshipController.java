package com.facebook.facebook.user_relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/userRelationships")

public class UserRelationshipController {

    //
    @Autowired
    UserRelationshipService userRelationshipService;
    //

    @PostMapping("")
    public UserRelationship addUserRelationship(@RequestBody UserRelationship userRelationship) {
        userRelationship.setTimeCreated(new Timestamp(new Date().getTime()));
        return userRelationshipService.addUserRelationship(userRelationship);
    }

    @PutMapping("")
    public UserRelationship updateUserRelationship(@RequestBody UserRelationship userRelationship) {
        return userRelationshipService.updateUserRelationship(userRelationship);
    }

    @DeleteMapping("")
    public void deleteUserRelationship(@RequestBody UserRelationship userRelationship) {
        userRelationshipService.deleteUserRelationship(userRelationship);
    }


}
