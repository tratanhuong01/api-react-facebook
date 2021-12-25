package com.facebook.facebook.view_story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ViewStoryRepository extends JpaRepository<ViewStory,Long> {
}
