package com.facebook.facebook.dto;

import com.facebook.facebook.group_message.GroupMessage;
import com.facebook.facebook.messages.Messages;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class MessageByGroup {

    List<Users> usersList;
    GroupMessage groupMessage;
    Messages messages;

}
