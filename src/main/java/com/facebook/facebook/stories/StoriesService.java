package com.facebook.facebook.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class StoriesService {

    //
    @Autowired
    StoriesRepository storiesRepository;
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

}
