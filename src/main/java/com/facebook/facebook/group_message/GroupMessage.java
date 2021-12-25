package com.facebook.facebook.group_message;

import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_message")
@Getter
@Setter

public class GroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userGroupMessage;

    @Column
    String color;

    @Column
    String theme;

    @Column
    String emoji;

    @Column
    String nameGroupMessage;

    @Column
    Timestamp timeCreated;

}
