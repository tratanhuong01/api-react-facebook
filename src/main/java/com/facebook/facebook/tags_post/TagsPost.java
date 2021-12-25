package com.facebook.facebook.tags_post;

import com.facebook.facebook.posts.Posts;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tags_post")
@Getter
@Setter

public class TagsPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_post")
    Posts postTagPost;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userTagPost;

    @Column
    Timestamp timeCreated;

}
