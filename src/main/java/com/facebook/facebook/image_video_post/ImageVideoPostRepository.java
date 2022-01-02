package com.facebook.facebook.image_video_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ImageVideoPostRepository extends JpaRepository<ImageVideoPost,Long> {

    @Query(value = "SELECT * FROM image_video_post WHERE id_post = ?1 ",nativeQuery = true)
    List<ImageVideoPost> getImageVideoPostByIdPost(Long idPost);

}
