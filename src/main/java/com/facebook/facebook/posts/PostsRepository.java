package com.facebook.facebook.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

}
