package com.facebook.facebook.group_story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GroupStoryRepository extends JpaRepository<GroupStory,Long> {

    @Query(value = "SELECT group_story.* FROM group_story INNER JOIN user_relationship ON group_story.id_user " +
            " = user_relationship.id_friend WHERE user_relationship.id_user = ?1 AND user_relationship.status = 3   " +
            " AND FLOOR(extract(epoch from (NOW() - group_story.time_created))) < 86400 " +
            " ORDER BY group_story.time_created DESC OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<GroupStory> getGroupStoryByIdUserToday(Long idUser,Integer offset,Integer limit);

    @Query(value = "SELECT group_story.* FROM group_story WHERE group_story.id_user = ?1 AND  " +
            " FLOOR(extract(epoch from (NOW() - group_story.time_created))) < 86400 ",nativeQuery = true)
    GroupStory getGroupStoryByIdUserToday(Long idUser);

    @Query(value = "SELECT * FROM group_story WHERE id_user = ?1 AND " +
            "FLOOR(extract(epoch from (NOW() - group_story.time_created))) < 86400",nativeQuery = true)
    List<GroupStory> checkGroupStoryHave(Long idUser);

}
