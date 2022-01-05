package com.facebook.facebook.feel_comment;

import com.facebook.facebook.comment_post.CommentPost;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "feel_comment")
@Getter
@Setter

public class FeelComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_comment_post")
    CommentPost commentPostFeelComment;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userFeelComment;

    @Column
    String content;

    @Column
    Integer typeFeelComment;

    @Column
    Timestamp timeCreated;

}
