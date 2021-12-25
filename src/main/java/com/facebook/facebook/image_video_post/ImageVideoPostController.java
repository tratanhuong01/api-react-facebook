package com.facebook.facebook.image_video_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/imageVideoPosts")

public class ImageVideoPostController {

    //
    @Autowired
    ImageVideoPostService imageVideoPostService;
    //

    @PostMapping("")
    public ImageVideoPost addImageVideoPost(@RequestBody ImageVideoPost imageVideoPost) {
        return imageVideoPostService.addImageVideoPost(imageVideoPost);
    }

    @PutMapping("")
    public ImageVideoPost updateImageVideoPost(@RequestBody ImageVideoPost imageVideoPost) {
        return imageVideoPostService.updateImageVideoPost(imageVideoPost);
    }

    @DeleteMapping("")
    public void deleteImageVideoPost(@RequestBody ImageVideoPost imageVideoPost) {
        imageVideoPostService.deleteImageVideoPost(imageVideoPost);
    }


}
