package com.facebook.facebook.tags_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TagsPostRepository extends JpaRepository<TagsPost,Long> {
}
