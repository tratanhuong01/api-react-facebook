package com.facebook.facebook.comment_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/commentPosts")

public class CommentPostController {

    //
    @Autowired
    CommentPostService commentPostService;
    //

    @PostMapping("")
    public CommentPost addCommentPost(@RequestBody CommentPost commentPost) {
        commentPost.setTimeCreated(new Timestamp(new Date().getTime()));
        return commentPostService.addCommentPost(commentPost);
    }

    @PutMapping("")
    public CommentPost updateCommentPost(@RequestBody CommentPost commentPost) {
        return commentPostService.updateCommentPost(commentPost);
    }

    @DeleteMapping("")
    public void deleteCommentPost(@RequestBody CommentPost commentPost) {
        commentPostService.deleteCommentPost(commentPost);
    }


}
