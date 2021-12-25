package com.facebook.facebook.feel_comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FeelCommentRepository extends JpaRepository<FeelComment,Long> {
}
