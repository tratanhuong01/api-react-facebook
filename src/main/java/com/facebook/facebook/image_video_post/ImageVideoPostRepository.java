package com.facebook.facebook.image_video_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ImageVideoPostRepository extends JpaRepository<ImageVideoPost,Long> {

    @Query(value = "SELECT * FROM image_video_post WHERE id_post = ?1 ",nativeQuery = true)
    List<ImageVideoPost> getImageVideoPostByIdPost(Long idPost);

    @Query(value = "SELECT image_video_post.* FROM image_video_post INNER JOIN posts ON posts.id = " +
            " image_video_post.id_post WHERE posts.id_user = ?1 ORDER BY posts.time_created DESC ",nativeQuery = true)
    List<ImageVideoPost> getImageVideoPostByIdUser(Long idUser);

    @Query(value = "SELECT image_video_post.* FROM image_video_post INNER JOIN posts ON posts.id = " +
            " image_video_post.id_post WHERE posts.id_user = ?1 AND image_video_post.type_image_video_post = ?2 " +
            " posts.id_user = ?1 ORDER BY posts.time_created DESC ",nativeQuery = true)
    List<ImageVideoPost> getImageVideoPostByIdUser(Long idUser,Integer type);


    @Query(value = "SELECT image_video_post.* FROM image_video_post INNER JOIN posts ON posts.id = " +
            " image_video_post.id_post WHERE posts.id_user = ?1 ORDER BY posts.time_created DESC " +
            " OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<ImageVideoPost> getImageVideoPostByIdUserLimit(Long idUser,Integer offset,Integer limit);

    @Query(value = "SELECT image_video_post.* FROM image_video_post INNER JOIN posts ON posts.id = " +
            " image_video_post.id_post WHERE posts.id_user = ?1 AND image_video_post.type_image_video_post = ?2 " +
            " ORDER BY posts.time_created DESC OFFSET ?3 LIMIT ?4 ",nativeQuery = true)
    List<ImageVideoPost> getImageVideoPostByIdUserLimit(Long idUser,Integer type,Integer offset,Integer limit);

}
