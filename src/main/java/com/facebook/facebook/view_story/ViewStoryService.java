package com.facebook.facebook.view_story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class ViewStoryService {

    //
    @Autowired
    ViewStoryRepository viewStoryRepository;
    //

    public ViewStory addViewStory(ViewStory viewStory) {
        viewStory.setTimeCreated(new Timestamp(new Date().getTime()));
        return viewStoryRepository.save(viewStory);
    }

    public ViewStory updateViewStory(ViewStory viewStory) {
        return viewStoryRepository.save(viewStory);
    }

    public void deleteViewStory(ViewStory viewStory) {
        viewStoryRepository.delete(viewStory);
    }

}
