package com.facebook.facebook.tags_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface TagsPostRepository extends JpaRepository<TagsPost,Long> {

    @Query(value = "SELECT * FROM tags_post WHERE id_post = ?1 ",nativeQuery = true)
    List<TagsPost> getTagsPostByIdPost(Long idPost);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tags_post WHERE id_post = ?1 ",nativeQuery = true)
    Integer deleteTagsPostByIdPost(Long idPost);

}
