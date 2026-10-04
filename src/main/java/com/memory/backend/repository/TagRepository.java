package com.memory.backend.repository;

import com.memory.backend.dto.TagDTO;
import com.memory.backend.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface TagRepository
    extends JpaRepository<Tag,Long> {
    Optional<Tag> findByName(String name);

    @Query("SELECT COUNT(m) FROM MemoryItem m JOIN m.tags t WHERE t.id= :tagId")
    long countMemoriesByTagId(@Param("tagId") Long tagId);

    @Query("SELECT new com.memory.backend.dto.TagDTO(t.id, t.name, COUNT(m)) FROM MemoryItem m JOIN m.tags t GROUP BY t.id,t.name")
    List<TagDTO> findAllTagsWithCount();
}
