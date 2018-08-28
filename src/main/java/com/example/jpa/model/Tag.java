package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Setter;
import lombok.Getter;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @NotNull
    @Size(max = 100)
    @NaturalId
    @Getter @Setter
    private String name;

    @JsonBackReference //무한루프 X
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tags")
    @Getter @Setter
    private Set<Post> posts = new HashSet<>();

    public Tag() {

    }

    public Tag(String name) {
        this.name = name;
    }

    // Getters and Setters (Omitted for brevity)
}
