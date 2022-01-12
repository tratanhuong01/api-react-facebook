package com.facebook.facebook.comment_post;

import com.facebook.facebook.dto.CommentChild;
import com.facebook.facebook.dto.CommentDetail;
import com.facebook.facebook.feel_comment.FeelComment;
import com.facebook.facebook.feel_comment.FeelCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class CommentPostService {

    //
    @Autowired
    CommentPostRepository commentPostRepository;
    @Autowired
    FeelCommentRepository feelCommentRepository;
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

    public List<CommentDetail> getCommentLevel1ByIdPost(Long idPost,Integer offset,Integer limit) {
        List<CommentPost> commentPostList = commentPostRepository.getListCommentPostLevel1(idPost, offset, limit);
        return returnListCommentDetail(commentPostList);
    }

    public List<CommentChild> getCommentLevel2ByIdCommentReply(Long idComment,Integer offset,Integer limit) {
        return returnListCommentChild(commentPostRepository.getListCommentPostLevel2(idComment, offset, limit));
    }

    public List<CommentDetail> returnListCommentDetail(List<CommentPost> commentPostList) {
        List<CommentDetail> commentDetailList = new ArrayList<>();
        for (CommentPost commentPost: commentPostList) {
            CommentDetail commentDetail = new CommentDetail();
            commentDetail.setCommentPostLevel1(returnCommentChild(commentPost));
            commentDetail.setCommentPostLevel2List(
                   returnListCommentChild(commentPostRepository.getListCommentPostLevel2(commentPost.getId(),
                           0,2)));
            commentDetail.setCommentLevel2Length(commentPostRepository.getCommentPostLevel2Length(commentPost.getId()));
            commentDetailList.add(commentDetail);
        }
        return commentDetailList;
    }

    public List<CommentChild> returnListCommentChild(List<CommentPost> commentPostList) {
        List<CommentChild> commentChildList = new ArrayList<>();
        for (CommentPost commentPost : commentPostList) {
            commentChildList.add(returnCommentChild(commentPost));
        }
        return commentChildList;
    }

    public CommentChild returnCommentChild(CommentPost commentPost) {
        CommentChild commentChild = new CommentChild();
        commentChild.setCommentPost(commentPost);
        commentChild.setFeelCommentList(feelCommentRepository.getFeelCommentByIdCommentPost(commentPost.getId()));
        return commentChild;
    }

}
