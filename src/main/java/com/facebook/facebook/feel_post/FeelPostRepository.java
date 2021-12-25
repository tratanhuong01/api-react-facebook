package com.facebook.facebook.feel_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FeelPostRepository extends JpaRepository<FeelPost,Long> {
}
