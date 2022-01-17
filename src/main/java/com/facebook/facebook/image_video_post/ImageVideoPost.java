package com.facebook.facebook.image_video_post;

import com.facebook.facebook.posts.Posts;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "image_video_post")
@Getter
@Setter

public class ImageVideoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_post")
    Posts postImageVideoPost;

    @Column
    String src;

    @Column
    Integer typeImageVideoPost;

    @Column
    Timestamp timeCreated;

}
