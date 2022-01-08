package com.facebook.facebook.dto;

import com.facebook.facebook.feel_post.FeelPost;
import com.facebook.facebook.image_video_post.ImageVideoPost;
import com.facebook.facebook.posts.Posts;
import com.facebook.facebook.tags_post.TagsPost;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class PostDetail {

    Posts post;
    List<FeelPost> feelPostList;
    Integer commentLength;
    Integer commentLevel1Length;
    List<ImageVideoPost> imageVideoPostList;
    List<CommentDetail> commentDetailList;
    List<TagsPost> tagPostList;
}
