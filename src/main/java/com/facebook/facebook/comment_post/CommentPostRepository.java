package com.facebook.facebook.comment_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {

    @Query(value = "SELECT COUNT(*) FROM comment_post WHERE id_post = ?1 ",nativeQuery = true)
    Integer getCountCommentPostByIdPost(Long idPost);

    @Query(value = "SELECT * FROM comment_post WHERE id_post = ?1 AND reply_comment IS NULL ORDER BY " +
            "time_created DESC OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<CommentPost> getListCommentPostLevel1(Long idPost,Integer offset,Integer limit);

    @Query(value = "SELECT * FROM comment_post WHERE reply_comment = ?1 ORDER BY " +
            "time_created DESC OFFSET ?2 LIMIT ?3",nativeQuery = true)
    List<CommentPost> getListCommentPostLevel2(Long idComment,Integer offset,Integer limit);

}
