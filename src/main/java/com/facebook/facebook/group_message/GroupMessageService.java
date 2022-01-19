package com.facebook.facebook.group_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class GroupMessageService {

    //
    @Autowired
    GroupMessageRepository groupMessageRepository;
    //

    public GroupMessage addGroupMessage(GroupMessage groupMessage) {
        groupMessage.setTimeCreated(new Timestamp(new Date().getTime()));
        return groupMessageRepository.save(groupMessage);
    }

    public GroupMessage updateGroupMessage(GroupMessage groupMessage) {
        return groupMessageRepository.save(groupMessage);
    }

    public void deleteGroupMessage(GroupMessage groupMessage) {
        groupMessageRepository.delete(groupMessage);
    }

    public GroupMessage getGroupMessage(String queryGroupMessage) {
        return groupMessageRepository.getGroupMessage(queryGroupMessage);
    }

    public GroupMessage getGroupMessageType(String queryGroupMessage) {
        return groupMessageRepository.getGroupMessageType(Long.parseLong(queryGroupMessage));
    }


}
