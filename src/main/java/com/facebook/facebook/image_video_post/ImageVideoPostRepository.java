package com.facebook.facebook.image_video_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ImageVideoPostRepository extends JpaRepository<ImageVideoPost,Long> {
}
