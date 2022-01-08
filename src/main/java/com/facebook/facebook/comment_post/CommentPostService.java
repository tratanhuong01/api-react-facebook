package com.facebook.facebook.comment_post;

import com.facebook.facebook.dto.CommentDetail;
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

    public List<CommentPost> getCommentLevel2ByIdCommentReply(Long idComment,Integer offset,Integer limit) {
        return commentPostRepository.getListCommentPostLevel2(idComment, offset, limit);
    }

    public List<CommentDetail> returnListCommentDetail(List<CommentPost> commentPostList) {
        List<CommentDetail> commentDetailList = new ArrayList<>();
        for (CommentPost commentPost: commentPostList) {
            CommentDetail commentDetail = new CommentDetail();
            commentDetail.setCommentPostLevel1(commentPost);
            commentDetail.setCommentPostLevel2List(
                    commentPostRepository.getListCommentPostLevel2(commentPost.getId(),0,2));
            commentDetail.setCommentLevel2Length(commentPostRepository.getCommentPostLevel2Length(commentPost.getId()));
            commentDetailList.add(commentDetail);
        }
        return commentDetailList;
    }

}
