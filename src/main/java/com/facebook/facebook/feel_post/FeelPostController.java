package com.facebook.facebook.feel_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("feelPosts")

public class FeelPostController {

    //
    @Autowired
    FeelPostService feelPostService;
    //

    @GetMapping("")
    public List<FeelPost> getFeelPostByIdPost(@RequestParam Long idPost) {
        return feelPostService.feelPostRepository.getFeelPostByIdPost(idPost);
    }

    @PostMapping("")
    public FeelPost addFeelPost(@RequestBody FeelPost feelPost) {
        return feelPostService.addFeelPost(feelPost);
    }

    @PutMapping("")
    public FeelPost updateFeelPost(@RequestBody FeelPost feelPost) {
        return feelPostService.updateFeelPost(feelPost);
    }

    @DeleteMapping("")
    public void deleteFeelPost(@RequestBody FeelPost feelPost) {
        feelPostService.deleteFeelPost(feelPost);
    }

    @GetMapping("/check")
    public FeelPost checkUserIsFeelPost(@RequestParam Long idPost,@RequestParam Long idUser) {
        return feelPostService.checkUserIsFeelPost(idPost, idUser);
    }

}
