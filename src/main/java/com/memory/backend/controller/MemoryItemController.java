package com.memory.backend.controller;

import com.memory.backend.entity.MemoryItem;
import com.memory.backend.service.MemoryItemService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memories")//相当于给这个 Controller 设置一个公共前缀。
public class MemoryItemController {

    private final MemoryItemService memoryItemService;

    public MemoryItemController(MemoryItemService memoryItemService){
        this.memoryItemService=memoryItemService;
    }



    @PostMapping//向服务器提交数据，通常用于创建新数据
    public MemoryItem createMemory(@RequestBody MemoryItem memoryItem){//把请求体中的 JSON 数据，转换成一个 Java 的 MemoryItem 对象
        return memoryItemService.createMemory(memoryItem);
    }

    @GetMapping
    public List<MemoryItem> getAllMemories(){
        return memoryItemService.getAllMemories();
    }

    @GetMapping("/{id}")
    public MemoryItem getMemoryById( @PathVariable Long id){
        return memoryItemService.getMemoryById(id);
    }

    @PutMapping("/{id}")
    public MemoryItem updateMemory(@PathVariable Long id,
                                   @RequestBody MemoryItem memoryItem){
        return memoryItemService.updateMemory(id,memoryItem);
    }

    @DeleteMapping("/{id}")
    public void deleteMemory(@PathVariable Long id){
        memoryItemService.deleteMemory(id);
    }

    @GetMapping("/search")
    public List<MemoryItem> searchMemories(@RequestParam("keyword") String keyword){
        return memoryItemService.searchMemories(keyword);
    }


}
