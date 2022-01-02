package com.facebook.facebook.image_video_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class ImageVideoPostService {

    //
    @Autowired
    ImageVideoPostRepository imageVideoPostRepository;
    //

    public ImageVideoPost addImageVideoPost(ImageVideoPost imageVideoPost) {
        imageVideoPost.setTimeCreated(new Timestamp(new Date().getTime()));
        return imageVideoPostRepository.save(imageVideoPost);
    }

    public ImageVideoPost updateImageVideoPost(ImageVideoPost imageVideoPost) {
        return imageVideoPostRepository.save(imageVideoPost);
    }

    public void deleteImageVideoPost(ImageVideoPost imageVideoPost) {
        imageVideoPostRepository.delete(imageVideoPost);
    }

}
