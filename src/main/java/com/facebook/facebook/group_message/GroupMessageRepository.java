package com.facebook.facebook.group_message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface GroupMessageRepository extends JpaRepository<GroupMessage,Long> {

    @Query(value = "SELECT * FROM group_message WHERE query_group_message = ?1 OFFSET 0 LIMIT 1",nativeQuery = true)
    GroupMessage getGroupMessage(String queryGroupMessage);

    @Query(value = "SELECT * FROM group_message WHERE id = ?1 ",nativeQuery = true)
    GroupMessage getGroupMessageById(Long idGroupMessage);

}
