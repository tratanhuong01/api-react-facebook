package com.facebook.facebook.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")

public class PostsController {

    //
    @Autowired
    PostsService postsService;
    //

    @GetMapping("")
    public List<Posts> getPostsByIdUser(@RequestParam Long idUser,@RequestParam(required = false) Integer offset,
                                        @RequestParam(required = false) Integer limit) {
        return postsService.getPostsByIdUser(idUser,offset,limit);
    }

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
