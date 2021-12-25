package com.facebook.facebook.view_story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/viewStories")

public class ViewStoryController {

    //
    @Autowired
    ViewStoryService viewStoryService;
    //

    @PostMapping("")
    public ViewStory addViewStory(@RequestBody ViewStory viewStory) {
        return viewStoryService.addViewStory(viewStory);
    }

    @PutMapping("")
    public ViewStory updateViewStory(@RequestBody ViewStory viewStory) {
        return viewStoryService.updateViewStory(viewStory);
    }

    @DeleteMapping("")
    public void deleteViewStory(@RequestBody ViewStory viewStory) {
        viewStoryService.deleteViewStory(viewStory);
    }

}
