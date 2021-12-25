package com.facebook.facebook.messages;

import com.facebook.facebook.group_message.GroupMessage;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
@Getter
@Setter

public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userMessage;

    @ManyToOne
    @JoinColumn(name = "id_group_message")
    GroupMessage groupMessageMessage;

    @Column
    String content;

    @Column
    String dataMessage;

    @Column
    Long replyMessage;

    @Column
    Integer typeMessage;

    @Column
    Timestamp timeCreated;

}
