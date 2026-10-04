package com.memory.backend.service;

import com.memory.backend.dto.TagDTO;
import com.memory.backend.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    public long countMemoriesByTagId(Long tagId){
        return tagRepository.countMemoriesByTagId(tagId);
    }

    public List<TagDTO> findAllTagsWithCount(){
        return tagRepository.findAllTagsWithCount();
    }
}
