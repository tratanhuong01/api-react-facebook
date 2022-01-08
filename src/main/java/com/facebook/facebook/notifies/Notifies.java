package com.facebook.facebook.notifies;

import com.facebook.facebook.users.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notifies")
@Getter
@Setter

public class Notifies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users userNotify;

    @Column
    String content;

    @Column
    String dataNotify;

    @Column
    Integer typeNotify;

    @Column
    Timestamp timeCreated;

}
