package com.facebook.facebook.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query(value = "SELECT * FROM users WHERE users.email = ?1 OR users.phone = ?1 ",nativeQuery = true)
    List<Users> checkRegister(String emailOrPhone);

    @Query(value = "SELECT * FROM users WHERE id = ?1 ",nativeQuery = true)
    Users getUserById(Long id);

    @Query(value = "SELECT * FROM users WHERE (email = ?1 OR phone = ?1 ) AND password = ?2 ",nativeQuery = true)
    Users checkLogin(String emailOrPhone,String password);

    @Query(value = "SELECT users.* FROM users INNER JOIN user_relationship ON users.id = user_relationship.id_user " +
            " WHERE user_relationship.id_friend = ?1 AND user_relationship.status = 3 AND users.is_online = 1 " +
            " OFFSET ?2 LIMIT ?3 ",nativeQuery = true)
    List<Users> getUserFriendOnlineByIdUser(Long idUser,Integer offset,Integer limit);

    @Query(value = "SELECT * FROM users WHERE users.id NOT IN " +
            " (SELECT id_user FROM user_relationship WHERE id_user = ?1 GROUP BY id_user) " +
            " AND id != ?1 AND id != ?2 OFFSET 0 LIMIT 10",nativeQuery = true)
    List<Users> getTintUserByIdUser(Long idUser,Long idView);
}
