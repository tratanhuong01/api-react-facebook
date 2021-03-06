package com.facebook.facebook.stories;

import com.facebook.facebook.group_story.GroupStory;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stories")
@Getter
@Setter

public class Stories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_group_story")
    GroupStory groupStory;

    @Column
    String music;

    @Column
    String src;

    @Column
    Integer typeStory;

    @Column
    Timestamp timeCreated;

}
