package com.facebook.facebook.user_relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class UserRelationshipService {

    //
    @Autowired
    UserRelationshipRepository userRelationshipRepository;
    //

    public UserRelationship addUserRelationship(UserRelationship userRelationship) {
        userRelationship.setTimeCreated(new Timestamp(new Date().getTime()));
        return userRelationshipRepository.save(userRelationship);
    }

    public UserRelationship updateUserRelationship(UserRelationship userRelationship) {
        return userRelationshipRepository.save(userRelationship);
    }

    public void deleteUserRelationship(UserRelationship userRelationship) {
        userRelationshipRepository.delete(userRelationship);
    }

}
