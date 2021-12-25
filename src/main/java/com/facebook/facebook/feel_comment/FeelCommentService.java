package com.facebook.facebook.feel_comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class FeelCommentService {

    //
    @Autowired
    FeelCommentRepository feelCommentRepository;
    //

    public FeelComment addFeelComment(FeelComment feelComment) {
        feelComment.setTimeCreated(new Timestamp(new Date().getTime()));
        return feelCommentRepository.save(feelComment);
    }

    public FeelComment updateFeelComment(FeelComment feelComment) {
        return feelCommentRepository.save(feelComment);
    }

    public void deleteFeelComment(FeelComment feelComment) {
        feelCommentRepository.delete(feelComment);
    }

}
