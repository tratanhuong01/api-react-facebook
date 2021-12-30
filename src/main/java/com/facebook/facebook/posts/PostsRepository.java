package com.facebook.facebook.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query(value = "SELECT * FROM posts WHERE id_user = ?1 ORDER BY time_created DESC ",nativeQuery = true)
    List<Posts> getPostsByIdUser(Long idUser);

}
