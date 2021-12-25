package com.facebook.facebook.view_story;

import com.facebook.facebook.stories.Stories;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "view_story")
@Getter
@Setter

public class ViewStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_story")
    Stories storyViewStory;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userViewStory;

    @Column
    Timestamp timeCreated;

}
