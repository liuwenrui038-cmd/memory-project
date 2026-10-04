package com.memory.backend.controller;

import com.memory.backend.dto.TagDTO;
import com.memory.backend.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService){
        this.tagService=tagService;
    }

    @GetMapping("/{tagId}/count")
    public Long countMemoriesByTagId(@PathVariable Long tagId){
        return tagService.countMemoriesByTagId(tagId);
    }

    @GetMapping
    public List<TagDTO> findAllTagsWithCount(){
        return tagService.findAllTagsWithCount();
    }
}
