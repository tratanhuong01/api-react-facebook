package com.facebook.facebook.dto;

import com.facebook.facebook.comment_post.CommentPost;
import com.facebook.facebook.feel_comment.FeelComment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class CommentChild {

    CommentPost commentPost;
    List<FeelComment> feelCommentList;

}
