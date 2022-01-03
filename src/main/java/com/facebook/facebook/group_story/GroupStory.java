package com.facebook.facebook.group_story;

import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_story")
@Getter
@Setter

public class GroupStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userGroupStory;

    @Column
    Timestamp timeCreated;

}
