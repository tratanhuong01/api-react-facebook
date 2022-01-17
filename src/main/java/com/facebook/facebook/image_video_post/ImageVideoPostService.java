package com.facebook.facebook.image_video_post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

    public List<ImageVideoPost> getImageVideoPostByIdUser(Long idUser,Integer offset,Integer limit,Integer type) {
        if (offset == null || limit == null)
            if (type == -1)
                return imageVideoPostRepository.getImageVideoPostByIdUser(idUser);
            else
                return imageVideoPostRepository.getImageVideoPostByIdUser(idUser,type);
        else
            if (type == -1)
                return imageVideoPostRepository.getImageVideoPostByIdUserLimit(idUser, offset, limit);
            else
                return imageVideoPostRepository.getImageVideoPostByIdUserLimit(idUser, type,offset, limit);
    }

}
