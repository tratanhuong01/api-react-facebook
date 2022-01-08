package com.facebook.facebook.comment_post;

import com.facebook.facebook.dto.CommentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/level1")
    public List<CommentDetail> getCommentLevel1ByIdPost(@RequestParam Long idPost,@RequestParam Integer offset,
                                                        @RequestParam Integer limit) {
        return commentPostService.getCommentLevel1ByIdPost(idPost, offset, limit);
    }

    @GetMapping("/level2")
    public List<CommentPost> getCommentLevel2ByIdCommentReply(@RequestParam Long idComment,@RequestParam Integer offset,
                                                              @RequestParam Integer limit) {
        return commentPostService.getCommentLevel2ByIdCommentReply(idComment, offset, limit);
    }

}
