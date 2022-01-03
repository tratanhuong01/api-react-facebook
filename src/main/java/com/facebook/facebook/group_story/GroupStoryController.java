package com.facebook.facebook.group_story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/groupStories")

public class GroupStoryController {

    //
    @Autowired
    GroupStoryService groupStoryService;
    //

    @PostMapping("")
    public GroupStory addGroupStory(@RequestBody GroupStory groupStory) {
        return groupStoryService.addGroupStory(groupStory);
    }

    @PutMapping("")
    public GroupStory updateGroupStory(@RequestBody GroupStory groupStory) {
        return groupStoryService.updateGroupStory(groupStory);
    }

    @DeleteMapping("")
    public void deleteGroupStory(@RequestBody GroupStory groupStory) {
        groupStoryService.deleteGroupStory(groupStory);
    }

    @GetMapping("")
    public List<GroupStory> getGroupStoryByIdUserToday(@RequestParam Long idUser,@RequestParam Integer offset,
                                                       @RequestParam Integer limit) {
        return groupStoryService.getGroupStoryByIdUserToday(idUser, offset, limit);
    }

    @GetMapping("/check")
    public List<GroupStory> checkGroupStoryHave(@RequestParam Long idUser) {
        return groupStoryService.checkGroupStoryHave(idUser);
    }

}
