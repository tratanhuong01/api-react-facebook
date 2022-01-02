package com.facebook.facebook.posts;

import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "posts")
@Getter
@Setter

public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userPost;

    @Column()
    String content;

    @Column
    String feel;

    @Column
    String local;

    @Column
    String activity;

    @Column
    String answerQuestion;

    @Column
    String backgroundPost;

    @Column
    Integer typePost;

    @Column
    Timestamp timeCreated;

}
