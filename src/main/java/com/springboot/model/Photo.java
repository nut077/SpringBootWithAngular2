package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Photo {

    @Id
    @GeneratedValue
    private Long photoId;

    private String photoName;
    private String title;
    private String description;
    private String imageName;

    @CreationTimestamp
    private Date created;

    @ManyToOne
    @JsonIgnore
    private User user;

    private int likes;

    @OneToMany(mappedBy = "photo", fetch = FetchType.EAGER)
    private List<Comment> commentList;
}
