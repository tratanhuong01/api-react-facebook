package com.facebook.facebook.stories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StoriesRepository extends JpaRepository<Stories,Long> {
}
