package com.example.jpa.repository;

import com.example.jpa.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Page<Tag> findById(Long id, Pageable pageable);
    List<Tag> findByName(@Param("name") String name);
}
