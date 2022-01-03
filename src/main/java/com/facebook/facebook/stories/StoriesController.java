package com.facebook.facebook.stories;

import com.facebook.facebook.dto.StoryDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    public List<StoryDetail> getStoryByIdUserToDay(@RequestParam Long idUser, @RequestParam Integer offset,
                                                   @RequestParam Integer limit) {
        return storiesService.getStoryByIdUserToDay(idUser,offset,limit);
    }

}
