package com.facebook.facebook.user_relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/userRelationships")

public class UserRelationshipController {

    //
    @Autowired
    UserRelationshipService userRelationshipService;
    //

    @GetMapping("/check/relationship")
    public UserRelationship checkRelationship(@RequestParam Long idUserProfile,@RequestParam Long idUserMain) {
        return userRelationshipService.checkRelationship(idUserProfile,idUserMain);
    }

    @PostMapping("")
    public UserRelationship addUserRelationship(@RequestBody UserRelationship userRelationship) {
        userRelationship.setTimeCreated(new Timestamp(new Date().getTime()));
        return userRelationshipService.addUserRelationship(userRelationship);
    }

    @PutMapping("")
    public void updateUserRelationship(@RequestParam Long idUserProfile,@RequestParam Long idUserMain,
                                                   @RequestParam Integer status) {
        userRelationshipService.updateUserRelationship(status,idUserProfile,idUserMain);
    }

    @DeleteMapping("")
    public void deleteUserRelationship(@RequestParam Long idUserProfile,@RequestParam Long idUserMain) {
        userRelationshipService.deleteUserRelationship(idUserProfile,idUserMain);
    }

    @GetMapping("/friends")
    public List<UserRelationship> getFriendByUserProfile(@RequestParam Long idUserMain,@RequestParam Integer status,
                                                         @RequestParam Integer limit, @RequestParam Integer offset,
                                                         @RequestParam String text) {
        return userRelationshipService.getFriendByUserProfile(idUserMain,status,offset,limit,text);
    }

    @GetMapping("/invite")
    public List<UserRelationship> getInviteFriendByIdUser(@RequestParam Long idUser,@RequestParam Integer offset,
                                                          @RequestParam Integer limit) {
        return userRelationshipService.getInviteFriendByIdUser(idUser,offset,limit);
    }

}
