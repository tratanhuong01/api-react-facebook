package com.facebook.facebook.user_relationship;

import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_relationship")
@Getter
@Setter

public class UserRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userUserRelationShip;

    @Column()
    Long idFriend;

    @Column
    Integer status;

    @Column
    Timestamp timeCreated;

}
