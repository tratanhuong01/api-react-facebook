package com.facebook.facebook.feel_comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface FeelCommentRepository extends JpaRepository<FeelComment,Long> {

    @Query(value = "SELECT * FROM feel_comment WHERE id_user = ?1 AND id_comment_post = ?2 ",nativeQuery = true)
    FeelComment checkUserFeelComment(Long idUser,Long idCommentPost);

    @Query(value = "SELECT * FROM feel_comment WHERE id_comment_post = ?1 ORDER BY time_created DESC ",nativeQuery = true)
    List<FeelComment> getFeelCommentByIdCommentPost(Long idCommentPost);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM feel_comment WHERE feel_comment.id_comment_post IN " +
            "(SELECT id FROM comment_post WHERE id_post = ?1) ",nativeQuery = true)
    Integer deleteFeelCommentBYIdPost(Long idPost);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM feel_comment WHERE feel_comment.id_comment_post = ?1 ",nativeQuery = true)
    Integer deleteFeelCommentBYIdCommentPost(Long idCommentPost);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM feel_comment WHERE feel_comment.id_comment_post IN " +
            " (SELECT id FROM comment_post WHERE reply_comment = ?1) ",nativeQuery = true)
    Integer deleteReplyFeelCommentBYIdCommentPost(Long idCommentPost);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM feel_comment WHERE feel_comment.id_comment_post IN " +
            " (SELECT id FROM comment_post WHERE reply_comment IN " +
            " (SELECT id FROM comment_post WHERE id_post = ?1 )) ",nativeQuery = true)
    Integer deleteReplyFeelCommentBYIdPost(Long idPost);


}
