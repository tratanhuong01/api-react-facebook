package com.facebook.facebook.data_message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DataMessageRepository extends JpaRepository<DataMessage,Long> {
}
