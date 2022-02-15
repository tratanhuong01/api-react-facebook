package com.facebook.facebook.posts;

import com.facebook.facebook.comment_post.CommentPost;
import com.facebook.facebook.comment_post.CommentPostRepository;
import com.facebook.facebook.dto.CommentChild;
import com.facebook.facebook.dto.CommentDetail;
import com.facebook.facebook.dto.PostDetail;
import com.facebook.facebook.feel_comment.FeelCommentRepository;
import com.facebook.facebook.feel_post.FeelPostRepository;
import com.facebook.facebook.image_video_post.ImageVideoPostRepository;
import com.facebook.facebook.tags_post.TagsPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class PostsService {

    //
    @Autowired
    PostsRepository postsRepository;
    @Autowired
    ImageVideoPostRepository imageVideoPostRepository;
    @Autowired
    FeelPostRepository feelPostRepository;
    @Autowired
    CommentPostRepository commentPostRepository;
    @Autowired
    TagsPostRepository tagsPostRepository;
    @Autowired
    FeelCommentRepository feelCommentRepository;
    //

    public Posts addPost(Posts posts) {
        posts.setTimeCreated(new Timestamp(new Date().getTime()));
        return postsRepository.save(posts);
    }

    public Posts updatePost(Posts posts) {
        return postsRepository.save(posts);
    }

    public void deletePost(Long idPost) {
        feelPostRepository.deleteFeelPostByIdPost(idPost);
        tagsPostRepository.deleteTagsPostByIdPost(idPost);
        feelCommentRepository.deleteFeelCommentBYIdPost(idPost);
        feelCommentRepository.deleteReplyFeelCommentBYIdPost(idPost);
        commentPostRepository.deleteCommentPostByIdPost(idPost);
        imageVideoPostRepository.deleteImageVideoPostByIdPost(idPost);
        postsRepository.deletePostById(idPost);
    }

    public List<PostDetail> getPostsByIdUser(Long idUser, Integer offset, Integer limit) {
        List<Posts> postsList = postsRepository.getPostsByIdUser(idUser,offset,limit);
        List<PostDetail> postDetailList = new ArrayList<>();
        for (Posts post : postsList) {
            postDetailList.add(returnPostDetail(post));
        }
        return postDetailList;
    }

    public PostDetail returnPostDetail(Posts post) {
        PostDetail postDetail = new PostDetail();
        postDetail.setPost(post);
        postDetail.setImageVideoPostList(imageVideoPostRepository.getImageVideoPostByIdPost(post.getId()));
        postDetail.setCommentLength(commentPostRepository.getCountCommentPostByIdPost(post.getId()));
        postDetail.setFeelPostList(feelPostRepository.getFeelPostByIdPost(post.getId()));
        postDetail.setCommentDetailList(returnListCommentDetail(post.getId()));
        postDetail.setCommentLevel1Length(commentPostRepository.getCountCommentPostLevel1ByIdPost(post.getId()));
        postDetail.setTagPostList(tagsPostRepository.getTagsPostByIdPost(post.getId()));
        //
        return postDetail;
    }

    public List<CommentDetail> returnListCommentDetail(Long idPost) {
        List<CommentPost> commentPostList = commentPostRepository.getListCommentPostLevel1(idPost,0,2);
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

    public PostDetail getPostById(Long id) {
        return returnPostDetail(postsRepository.getPostById(id));
    }

    public List<PostDetail> getPostHome(Long id,Integer offset,Integer limit) {
        List<Posts> postsList = postsRepository.getPostHome(id,offset,limit);
        List<PostDetail> postDetailList = new ArrayList<>();
        for (Posts post : postsList) {
            postDetailList.add(returnPostDetail(post));
        }
        return postDetailList;
    }

    public List<PostDetail> getWatchPost(Integer offset,Integer limit) {
        List<Posts> postsList = postsRepository.getWatchPost(offset,limit);
        List<PostDetail> postDetailList = new ArrayList<>();
        for (Posts post : postsList) {
            postDetailList.add(returnPostDetail(post));
        }
        return postDetailList;
    }

}
