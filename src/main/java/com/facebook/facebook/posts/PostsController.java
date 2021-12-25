package com.facebook.facebook.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")

public class PostsController {

    //
    @Autowired
    PostsService postsService;
    //



    @PostMapping("")
    public Posts addPost(@RequestBody Posts posts) {
        return postsService.addPost(posts);
    }

    @PutMapping("")
    public Posts updatePost(@RequestBody Posts posts) {
        return postsService.updatePost(posts);
    }

    @DeleteMapping("")
    public void deletePost(@RequestBody Posts posts) {
        postsService.deletePost(posts);
    }


}
