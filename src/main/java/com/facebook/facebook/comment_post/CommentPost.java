package com.facebook.facebook.comment_post;

import com.facebook.facebook.posts.Posts;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment_post")
@Getter
@Setter

public class CommentPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_post")
    Posts postCommentPost;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userCommentPost;

    @Column
    String content;

    @Column
    String dataComment;

    @Column
    Integer typeComment;

    @Column
    Long replyComment;

    @Column
    Timestamp timeCreated;

}
