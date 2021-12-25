package com.facebook.facebook.tags_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/tagsPosts")

public class TagsPostController {

    //
    @Autowired
    TagsPostService tagsPostService;
    //

    @PostMapping("")
    public TagsPost addTagsPost(@RequestBody TagsPost tagsPost) {
        return tagsPostService.addTagsPost(tagsPost);
    }

    @PutMapping("")
    public TagsPost updateTagsPost(@RequestBody TagsPost tagsPost) {
        return tagsPostService.updateTagsPost(tagsPost);
    }

    @DeleteMapping("")
    public void deleteTagsPost(@RequestBody TagsPost tagsPost) {
        tagsPostService.deleteTagsPost(tagsPost);
    }

}
