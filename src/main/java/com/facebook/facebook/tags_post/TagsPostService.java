package com.facebook.facebook.tags_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class TagsPostService {

    //
    @Autowired
    TagsPostRepository tagsPostRepository;
    //

    public TagsPost addTagsPost(TagsPost tagsPost) {
        tagsPost.setTimeCreated(new Timestamp(new Date().getTime()));
        return tagsPostRepository.save(tagsPost);
    }

    public TagsPost updateTagsPost(TagsPost tagsPost) {
        return tagsPostRepository.save(tagsPost);
    }

    public void deleteTagsPost(TagsPost tagsPost) {
        tagsPostRepository.delete(tagsPost);
    }

}
