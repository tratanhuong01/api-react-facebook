package com.facebook.facebook.messages;

import com.facebook.facebook.dto.MessageByGroup;
import com.facebook.facebook.dto.UpdateNickname;
import com.facebook.facebook.group_message.GroupMessage;
import com.facebook.facebook.group_message.GroupMessageRepository;
import com.facebook.facebook.users.Users;
import com.facebook.facebook.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class MessagesService {

    //
    @Autowired
    MessagesRepository messagesRepository;
    @Autowired
    GroupMessageRepository groupMessageRepository;
    @Autowired
    UsersRepository usersRepository;
    //

    public Messages addMessage(Messages messages) {
        messages.setTimeCreated(new Timestamp(new Date().getTime()));
        return messagesRepository.save(messages);
    }

    public Messages updateMessage(Messages messages) {
        return messagesRepository.save(messages);
    }

    public void deleteMessage(Messages messages) {
        messagesRepository.delete(messages);
    }

    public List<Messages> getMessageByIdGroupMessage(Long idGroupMessage,Integer offset,Integer limit) {
        return messagesRepository.getMessageByIdGroupMessage(idGroupMessage,offset,limit);
    }

    public List<MessageByGroup> getMessageByGroupByIdUser(Long idUser,Integer offset,Integer limit) {
        List<MessageByGroup> messageByGroupList = new ArrayList<>();
        List<Long> longList = messagesRepository.getDistinctIDGroupMessageByIdUser(idUser, offset, limit);
        for (Long longItem :longList) {
            messageByGroupList.add(returnMessageByGroup(longItem,idUser));
        }
        return messageByGroupList;
    }

    public MessageByGroup returnMessageByGroup(Long longItem,Long idUser) {
        MessageByGroup messageByGroup = new MessageByGroup();
        GroupMessage groupMessage = groupMessageRepository.getGroupMessageById(longItem);
        if (groupMessage != null) {
            List<Users> usersList = new ArrayList<>();
            String[] stringList = groupMessage.getQueryGroupMessage().split("-");
            for (String string : stringList) {
                if (!string.equals(String.valueOf(idUser))) {
                    usersList.add(usersRepository.getUserById(Long.parseLong(string)));
                }
            }
            messageByGroup.setUsersList(usersList);
            messageByGroup.setGroupMessage(groupMessage);
            messageByGroup.setMessages(messagesRepository.getMessageByGroupLimitOne(longItem));
        }
        return messageByGroup;
    }

    public List<Users> getUserByGroupMessage(Long idUser,String groupMessage) {
        List<Users> usersList = new ArrayList<>();
        String[] stringList = groupMessage.split("-");
        for (String string : stringList) {
            if (!string.equals(String.valueOf(idUser))) {
                usersList.add(usersRepository.getUserById(Long.parseLong(string)));
            }
        }
        return usersList;
    }

    public int updateNickname(UpdateNickname updateNickname) {
        return messagesRepository.updateNickNameUser(updateNickname.getContent(),updateNickname.getIdGroupMessage(),
                updateNickname.getIdUser(),updateNickname.getTypeMessage());
    }

}
