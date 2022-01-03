package com.facebook.facebook.stories;

import com.facebook.facebook.dto.StoryDetail;
import com.facebook.facebook.group_story.GroupStory;
import com.facebook.facebook.group_story.GroupStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class StoriesService {

    //
    @Autowired
    StoriesRepository storiesRepository;
    @Autowired
    GroupStoryRepository groupStoryRepository;
    //


    public Stories addStory(Stories stories) {
        stories.setTimeCreated(new Timestamp(new Date().getTime()));
        return storiesRepository.save(stories);
    }

    public Stories updateStory(Stories stories) {
        return storiesRepository.save(stories);
    }

    public void deleteStory(Stories stories) {
        storiesRepository.delete(stories);
    }

    public List<StoryDetail> getStoryByIdUserToDay(Long idUser, Integer offset, Integer limit) {
        List<GroupStory> groupStoryList = groupStoryRepository.getGroupStoryByIdUserToday(idUser, offset, limit);
        List<StoryDetail> storyDetailList = new ArrayList<>();
        GroupStory groupStoryMain = groupStoryRepository.getGroupStoryByIdUserToday(idUser);
        if (groupStoryMain != null)
            storyDetailList.add(returnStoryDetail(groupStoryMain));
        for (GroupStory groupStory : groupStoryList) {
            storyDetailList.add(returnStoryDetail(groupStory));
        }
        return storyDetailList;
    }

    public StoryDetail returnStoryDetail(GroupStory groupStory) {
        StoryDetail storyDetail = new StoryDetail();
        storyDetail.setGroupStory(groupStory);
        storyDetail.setStoryList(storiesRepository.getStoryByGroupStory(groupStory.getId()));
        return storyDetail;
    }

}
