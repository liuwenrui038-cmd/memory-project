package com.memory.backend.service;

import com.memory.backend.dto.TagDTO;
import com.memory.backend.entity.Tag;
import com.memory.backend.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    public Tag updateTag(Long id,Tag tag){
        Tag existingTag=tagRepository.findById(id).orElse(null);
        if(existingTag==null){
            return null;
        }
        existingTag.setName(tag.getName());
        return tagRepository.save(existingTag);
    }

    public long countMemoriesByTagId(Long tagId){
        return tagRepository.countMemoriesByTagId(tagId);
    }

    public List<TagDTO> findAllTagsWithCount(){
        return tagRepository.findAllTagsWithCount();
    }
}
