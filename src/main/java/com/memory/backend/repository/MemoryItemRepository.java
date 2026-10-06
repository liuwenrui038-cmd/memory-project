package com.memory.backend.repository;

import com.memory.backend.entity.MemoryItem;
import com.memory.backend.entity.MemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

//我要一个专门操作 MemoryItem 的数据库操作接口，它的主键类型是 Long。
public interface MemoryItemRepository
        extends JpaRepository<MemoryItem,Long>,
        JpaSpecificationExecutor<MemoryItem> {
    List<MemoryItem> findByTitleContaining(String keyword);
    List<MemoryItem> findByTags_Name(String name);

}
