package com.facebook.facebook.feel_comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface FeelCommentRepository extends JpaRepository<FeelComment,Long> {

    @Query(value = "SELECT * FROM feel_comment WHERE id_user = ?1 AND id_comment_post = ?2 ",nativeQuery = true)
    FeelComment checkUserFeelComment(Long idUser,Long idCommentPost);

}
