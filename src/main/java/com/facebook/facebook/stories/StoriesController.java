package com.facebook.facebook.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/stories")

public class StoriesController {

    //
    @Autowired
    StoriesService storiesService;
    //

    @PostMapping("")
    public Stories addStory(@RequestBody Stories stories) {
        return storiesService.addStory(stories);
    }

    @PutMapping("")
    public Stories updateStory(@RequestBody Stories stories) {
        return storiesService.updateStory(stories);
    }

    @DeleteMapping("")
    public void deleteStory(@RequestBody Stories stories) {
        storiesService.deleteStory(stories);
    }


}
