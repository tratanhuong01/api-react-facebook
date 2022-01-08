package com.facebook.facebook.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MessagesRepository extends JpaRepository<Messages,Long> {

    @Query(value = "SELECT * FROM messages WHERE id_group_message = ?1 ORDER BY time_created DESC",nativeQuery = true)
    List<Messages> getMessageByIdGroupMessage(Long idGroupMessage);

}
