package com.facebook.facebook.user_relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service

public class UserRelationshipService {

    //
    @Autowired
    UserRelationshipRepository userRelationshipRepository;
    //

    // 0 -> sent invite , 1 -> receive invite , 2 -> ís friend

    public UserRelationship addUserRelationship(UserRelationship userRelationship) {
        userRelationship.setTimeCreated(new Timestamp(new Date().getTime()));
        return userRelationshipRepository.save(userRelationship);
    }

    public void updateUserRelationship(Integer status ,Long idUserProfile,Long idUserMain) {
        userRelationshipRepository.updateUserRelationship(status,idUserProfile,idUserMain);
    }

    public void deleteUserRelationship(Long idUserProfile,Long idUserMain) {
        userRelationshipRepository.deleteUserRelationship(idUserProfile,idUserMain);
    }

    public UserRelationship checkRelationship(Long idUserProfile,Long idUserMain) {
        return userRelationshipRepository.checkRelationship(idUserMain,idUserProfile);
    }


    public List<UserRelationship> getFriendByUserProfile(Long idUserMain,Integer status,
                                                         Integer offset,Integer limit,String text) {
       if (text == null)
           return userRelationshipRepository.getFriendByUserProfile(idUserMain,status,
                   offset,limit);
       else
           return userRelationshipRepository.getFriendByUserProfile(idUserMain,status,text,
                   offset,limit);
    }


}
