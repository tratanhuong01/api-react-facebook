package com.facebook.facebook.stories;

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
    @JoinColumn(name = "id_user")
    Users userStory;

    @Column
    String music;

    @Column
    String src;

    @Column
    Integer typeStory;

    @Column
    Timestamp timeCreated;

}
