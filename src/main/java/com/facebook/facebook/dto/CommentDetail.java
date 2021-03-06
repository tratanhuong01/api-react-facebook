package com.facebook.facebook.dto;

import com.facebook.facebook.comment_post.CommentPost;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class CommentDetail {

    CommentChild commentPostLevel1;
    List<CommentChild> commentPostLevel2List;
    Integer commentLevel2Length;
}
