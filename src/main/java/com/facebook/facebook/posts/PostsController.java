package com.facebook.facebook.posts;

import com.facebook.facebook.dto.PostDetail;
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

    @GetMapping("/{id}")
    public PostDetail getPostById(@PathVariable Long id) {
        return postsService.getPostById(id);
    }

    @GetMapping("/home/{id}")
    public List<PostDetail> getPostHome(@PathVariable Long id,@RequestParam(required = false) Integer limit,
                                        @RequestParam(required = false) Integer offset) {
        return postsService.getPostHome(id,offset,limit);
    }

    @GetMapping("")
    public List<PostDetail> getPostsByIdUser(@RequestParam Long idUser, @RequestParam(required = false) Integer offset,
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
    public void deletePost(@RequestParam Long idPost) {
        postsService.deletePost(idPost);
    }

    @GetMapping("/watch")
    public List<PostDetail> getWatchHome(@RequestParam Integer offset,@RequestParam Integer limit) {
        return postsService.getWatchPost(offset, limit);
    }
}
