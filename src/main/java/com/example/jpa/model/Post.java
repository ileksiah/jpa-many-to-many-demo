package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id //@Id는 해당 프로퍼티가 테이블의 주키(primary key) 역할을 한다는 것
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    @Getter @Setter
    private String title;

    @NotNull
    @Size(max = 250)
    @Getter @Setter
    private String description;

    @NotNull
    @Lob
    @Getter @Setter
    private String content;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();


    //@JsonManagedReference
    //@JsonProperty("tags")
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "post_tags",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    @Getter @Setter
    private Set<Tag> tags = new HashSet<>();
    //private List<Tag> tags = new LinkedList<Tag>();

    public Post() {

    }

    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    // Getters and Setters (Omitted for brevity)
}
