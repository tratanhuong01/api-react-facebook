package com.facebook.facebook.feel_post;

import com.facebook.facebook.posts.Posts;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "feel_post")
@Getter
@Setter

public class FeelPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_post")
    Posts postFeelPost;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userFeelPost;

    @Column
    String content;

    @Column
    Integer typeFeelPost;

    @Column
    Timestamp timeCreated;

}
