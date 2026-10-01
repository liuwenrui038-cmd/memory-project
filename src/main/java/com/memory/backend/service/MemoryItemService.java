package com.memory.backend.service;

import com.memory.backend.entity.MemoryItem;
import com.memory.backend.entity.Tag;
import com.memory.backend.repository.MemoryItemRepository;
import com.memory.backend.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryItemService {

    private final MemoryItemRepository memoryItemRepository;
    private final TagRepository tagRepository;

    public MemoryItemService(MemoryItemRepository memoryItemRepository,TagRepository tagRepository){
        this.memoryItemRepository=memoryItemRepository;
        this.tagRepository=tagRepository;
    }

    public MemoryItem createMemory(MemoryItem memoryItem){
        List<Tag> actualTags= new ArrayList<>();

        for(Tag tag :memoryItem.getTags()){
            Optional<Tag> existingTag=
                    tagRepository.findByName(tag.getName());
            if(existingTag.isPresent()){
                Tag actualTag=existingTag.get();
                actualTags.add(actualTag);
            }else{
                Tag actualTag=tagRepository.save(tag);
                actualTags.add(actualTag);
            }
        }
        memoryItem.setTags(actualTags);
        return memoryItemRepository.save(memoryItem);
    }
    //
    public List<MemoryItem> getAllMemories(){
        return memoryItemRepository.findAll();
    }

    public MemoryItem getMemoryById(Long id){
        return memoryItemRepository.findById(id).orElse(null);
    }

    public MemoryItem updateMemory(Long id,MemoryItem memoryItem){
        MemoryItem existingMemory = memoryItemRepository.findById(id).orElse(null);//旧数据
        if(existingMemory==null){
            return null;
        }
        existingMemory.setTitle(memoryItem.getTitle());
        existingMemory.setType(memoryItem.getType());
        existingMemory.setFeeling(memoryItem.getFeeling());
        existingMemory.setDiscoverDate(memoryItem.getDiscoverDate());
        existingMemory.setFavorite(memoryItem.getFavorite());
        //existingMemory.setTags(memoryItem.getTags());错误
        List<Tag> actualTags=new ArrayList<>();
        for(Tag tag : memoryItem.getTags()){
            Optional<Tag> exitingTag=tagRepository.findByName(tag.getName());
            if(exitingTag.isPresent()){
                Tag actualTag=exitingTag.get();
                actualTags.add(actualTag);
            }else{
                Tag actualTag=tagRepository.save(tag);
                actualTags.add(actualTag);
            }

        }

        existingMemory.setTags(actualTags);

        return memoryItemRepository.save(existingMemory);
    }

    public void deleteMemory(Long id){
        memoryItemRepository.deleteById(id);
    }

    public List<MemoryItem> searchMemories(String keyword){
        return memoryItemRepository.findByTitleContaining(keyword);
    }

    public List<MemoryItem> searchMemoriesByTag(String name){
        return memoryItemRepository.findByTags_Name(name);
    }


}
