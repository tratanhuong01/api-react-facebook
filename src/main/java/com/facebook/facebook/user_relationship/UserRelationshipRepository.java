package com.facebook.facebook.user_relationship;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface UserRelationshipRepository extends JpaRepository<UserRelationship,Long> {

    Page<UserRelationship> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM user_relationship WHERE id_user = ?1 AND id_friend = ?2 ",nativeQuery = true)
    UserRelationship checkRelationship(Long idUserMain,Long idUserProfile);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_relationship WHERE id_user = ?1 AND id_friend = ?2 ",nativeQuery = true)
    Integer deleteUserRelationship(Long idUserProfile,Long idUserMain);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user_relationship SET status = ?1 WHERE id_user = ?2 AND id_friend = ?3 ",nativeQuery = true)
    Integer updateUserRelationship(Integer status,Long idUserProfile,Long idUserMain);

    @Query(value = "SELECT * FROM user_relationship WHERE id_friend = ?1 AND status = ?2 " +
            " offset ?3 limit ?4 ",nativeQuery = true)
    List<UserRelationship> getFriendByUserProfile(Long idUserMain,Integer status,Integer offset,
                                                  Integer limit);
    @Query(value = "SELECT user_relationship.* FROM user_relationship INNER JOIN users ON user_relationship.id_user " +
            " = users.id WHERE user_relationship.id_friend = :idUserMain AND user_relationship.status = :status AND " +
            " LOWER(CONCAT(users.first_name,' ',users.last_name)) LIKE LOWER(CONCAT('%',:text,'%')) " +
            " offset :offset limit :limit ",nativeQuery = true)
    List<UserRelationship> getFriendByUserProfile(@Param("idUserMain") Long idUserMain,@Param("status") Integer status,
                                                  @Param("text") String text,@Param("offset") Integer offset,
                                                  @Param("limit") Integer limit);
}
