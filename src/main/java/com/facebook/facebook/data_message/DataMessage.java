package com.facebook.facebook.data_message;

import com.facebook.facebook.messages.Messages;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "data_message")

public class DataMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_message")
    Messages messageDataMessage;

    @Column
    String src;

    @Column
    Integer typeDataMessage;

    @Column
    Timestamp timeCreated;

}
