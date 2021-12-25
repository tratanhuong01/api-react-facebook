package com.facebook.facebook.feel_message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FeelMessageRepository extends JpaRepository<FeelMessage,Long> {
}
