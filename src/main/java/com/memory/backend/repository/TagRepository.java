package com.memory.backend.repository;

import com.memory.backend.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface TagRepository
    extends JpaRepository<Tag,Long> {
    Optional<Tag> findByName(String name);

    @Query("SELECT COUNT(m) FROM MemoryItem m JOIN m.tags t WHERE t.id= :tagId")
    long countMemoriesByTagId(@Param("tagId") Long tagId);
}
