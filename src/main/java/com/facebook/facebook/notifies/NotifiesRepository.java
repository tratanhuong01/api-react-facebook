package com.facebook.facebook.notifies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NotifiesRepository extends JpaRepository<Notifies,Long> {
}
