package com.memory.backend.service;

import com.memory.backend.entity.MemoryItem;
import com.memory.backend.repository.MemoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryItemService {

    private final MemoryItemRepository memoryItemRepository;

    public MemoryItemService(MemoryItemRepository memoryItemRepository){
        this.memoryItemRepository=memoryItemRepository;
    }

    public MemoryItem createMemory(MemoryItem memoryItem){
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
    return memoryItemRepository.save(existingMemory);
    }

    public void deleteMemory(Long id){
        memoryItemRepository.deleteById(id);
    }

    public List<MemoryItem> searchMemories(String keyword){
        return memoryItemRepository.findByTitleContaining(keyword);
    }
}
