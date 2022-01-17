package com.facebook.facebook.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface MessagesRepository extends JpaRepository<Messages,Long> {

    @Query(value = "SELECT * FROM messages WHERE id_group_message = ?1 AND type_message != -1 ORDER BY time_created ASC " +
            " OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<Messages> getMessageByIdGroupMessage(Long idGroupMessage,Integer offset,Integer limit);

    @Query(value = "SELECT DISTINCT messages.id_group_message FROM messages WHERE messages.id_user = ?1 " +
            " AND type_message != -1 OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<Long> getDistinctIDGroupMessageByIdUser(Long idUser,Integer offset,Integer limit);

    @Query(value = "SELECT * FROM messages WHERE id_group_message = ?1 AND type_message != -1 ORDER BY time_created DESC " +
            "OFFSET 0 LIMIT 1 ",nativeQuery = true)
    Messages getMessageByGroupLimitOne(Long idGroupMessage);

    @Transactional
    @Modifying
    @Query(value = "UPDATE messages SET content = ?1 WHERE id_group_message = ?2 AND id_user = ?3 AND type_message = ?4 ",
    nativeQuery = true)
    int updateNickNameUser(String content,Long idGroupMessage,Long idUser,Integer typeMessage);

}
