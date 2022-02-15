package com.facebook.facebook.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query(value = "SELECT posts.* FROM posts LEFT JOIN tags_post ON tags_post.id_post = posts.id " +
            " WHERE posts.id_user = ?1 OR tags_post.id_user = ?1 GROUP BY posts.id " +
            " ORDER BY time_created DESC OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<Posts> getPostsByIdUser(Long idUser,Integer offset,Integer limit);

    @Query(value = "SELECT * FROM posts WHERE id = ?1 ",nativeQuery = true)
    Posts getPostById(Long id);

    @Query(value = "SELECT posts.* FROM posts INNER JOIN users ON users.id = posts.id_user INNER JOIN " +
            " user_relationship ON user_relationship.id_user = users.id WHERE user_relationship.id_friend = ?1 " +
            " AND user_relationship.status = 3 ORDER BY posts.time_created DESC OFFSET ?2 LIMIT ?3  ",nativeQuery = true)
    List<Posts> getPostHome(Long id,Integer offset,Integer limit);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM posts WHERE id = ?1 ",nativeQuery = true)
    Integer deletePostById(Long idPost);

    @Query(value = "SELECT posts.* FROM posts INNER JOIN image_video_post ON posts.id = " +
            " image_video_post.id_post WHERE image_video_post.type_image_video_post = 1 " +
            " ORDER BY image_video_post.time_created DESC OFFSET ?1 LIMIT ?2 ",nativeQuery = true)
    List<Posts> getWatchPost(Integer offset,Integer limit);

}
