package com.facebook.facebook.stories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StoriesRepository extends JpaRepository<Stories,Long> {

    @Query(value = "SELECT stories.* FROM stories WHERE id_group_story = ?1 " +
            "ORDER BY stories.time_created DESC ",nativeQuery = true)
    List<Stories> getStoryByGroupStory(Long idGroupStory);

    @Query(value = "SELECT stories.* FROM stories INNER JOIN group_story ON stories.id_group_story = " +
            " group_story.id WHERE group_story.id_user = ?1 ORDER BY stories.time_created DESC ",nativeQuery = true)
    List<Stories> getStoryByIdUser(Long idUser);

    @Query(value = "SELECT stories.* FROM stories INNER JOIN group_story ON stories.id_group_story = " +
            " group_story.id WHERE group_story.id_user = ?1 ORDER BY stories.time_created DESC " +
            " OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<Stories> getStoryByIdUser(Long idUser,Integer offset,Integer limit);

}
