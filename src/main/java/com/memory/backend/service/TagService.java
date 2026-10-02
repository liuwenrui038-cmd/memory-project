package com.memory.backend.service;

import com.memory.backend.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    public long countMemoriesByTagId(Long tagId){
        return tagRepository.countMemoriesByTagId(tagId);
    }
}
