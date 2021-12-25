package com.facebook.facebook.comment_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class CommentPostService {

    //
    @Autowired
    CommentPostRepository commentPostRepository;
    //

    public CommentPost addCommentPost(CommentPost commentPost) {
        commentPost.setTimeCreated(new Timestamp(new Date().getTime()));
        return commentPostRepository.save(commentPost);
    }

    public CommentPost updateCommentPost(CommentPost commentPost) {
        return commentPostRepository.save(commentPost);
    }

    public void deleteCommentPost(CommentPost commentPost) {
        commentPostRepository.delete(commentPost);
    }

}
