package com.facebook.facebook.feel_message;

import com.facebook.facebook.messages.Messages;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "feel_message")
@Getter
@Setter

public class FeelMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_message")
    Messages messageFeelMessage;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userFeelMessage;

    @Column
    Integer typeFeelMessage;

    @Column
    Timestamp timeCreated;

}
