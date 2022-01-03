package com.facebook.facebook.dto;

import com.facebook.facebook.group_story.GroupStory;
import com.facebook.facebook.stories.Stories;
import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class StoryDetail {

    GroupStory groupStory;
    List<Stories> storyList;

}
