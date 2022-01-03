package com.facebook.facebook.group_story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service

public class GroupStoryService {

    @Autowired
    GroupStoryRepository groupStoryRepository;

    public GroupStory addGroupStory(GroupStory groupStory) {
        groupStory.setTimeCreated(new Timestamp(new Date().getTime()));
        return groupStoryRepository.save(groupStory);
    }

    public GroupStory updateGroupStory(GroupStory groupStory) {
        return groupStoryRepository.save(groupStory);
    }

    public void deleteGroupStory(GroupStory groupStory) {
        groupStoryRepository.delete(groupStory);
    }

    public List<GroupStory> getGroupStoryByIdUserToday(Long idUser,Integer offset,Integer limit) {
        return groupStoryRepository.getGroupStoryByIdUserToday(idUser, offset, limit);
    }

    public List<GroupStory> checkGroupStoryHave(Long idUser) {
        return groupStoryRepository.checkGroupStoryHave(idUser);
    }
}
