package com.facebook.facebook.feel_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class FeelPostService {

    //
    @Autowired
    FeelPostRepository feelPostRepository;
    //

    public FeelPost addFeelPost(FeelPost feelPost) {
        feelPost.setTimeCreated(new Timestamp(new Date().getTime()));
        return feelPostRepository.save(feelPost);
    }

    public FeelPost updateFeelPost(FeelPost feelPost) {
        return feelPostRepository.save(feelPost);
    }

    public void deleteFeelPost(FeelPost feelPost) {
        feelPostRepository.delete(feelPost);
    }

    public FeelPost checkUserIsFeelPost(Long idPost,Long idUser) {
        return feelPostRepository.checkUserIsFeelPost(idPost, idUser);
    }

}
