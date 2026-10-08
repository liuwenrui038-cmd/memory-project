package com.memory.backend.controller;

import com.memory.backend.dto.TagDTO;
import com.memory.backend.entity.Tag;
import com.memory.backend.service.TagService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable Long id,
                         @RequestBody Tag tag){
        return tagService.updateTag(id,tag);
    }
}
