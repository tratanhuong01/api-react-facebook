package com.facebook.facebook.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class PostsService {

    //
    @Autowired
    PostsRepository postsRepository;
    //

    public Posts addPost(Posts posts) {
        posts.setTimeCreated(new Timestamp(new Date().getTime()));
        return postsRepository.save(posts);
    }

    public Posts updatePost(Posts posts) {
        return postsRepository.save(posts);
    }

    public void deletePost(Posts posts) {
        postsRepository.delete(posts);
    }

}
