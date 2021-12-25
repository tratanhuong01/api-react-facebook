package com.facebook.facebook.comment_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {
}
