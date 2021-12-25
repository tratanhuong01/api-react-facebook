package com.facebook.facebook.group_message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GroupMessageRepository extends JpaRepository<GroupMessage,Long> {
}
