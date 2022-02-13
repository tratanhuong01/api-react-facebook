package com.facebook.facebook.feel_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface FeelPostRepository extends JpaRepository<FeelPost,Long> {

    @Query(value = "SELECT * FROM feel_post WHERE id_post = ?1 ",nativeQuery = true)
    List<FeelPost> getFeelPostByIdPost(Long idPost);

    @Query(value = "SELECT * FROM feel_post WHERE id_post = ?1 AND id_user = ?2 ",nativeQuery = true)
    FeelPost checkUserIsFeelPost(Long idPost,Long idUser);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM feel_post WHERE id_post = ?1 ",nativeQuery = true)
    Integer deleteFeelPostByIdPost(Long idPost);

}
