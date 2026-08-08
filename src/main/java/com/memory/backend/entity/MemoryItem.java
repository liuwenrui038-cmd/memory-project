package com.memory.backend.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name="memory_item")
public class MemoryItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //表示告诉数据库 id不需要手动填写，自动递增
    private Long id;

    private String title;
    //默认VARCHAR（255）

    @Column(columnDefinition="TEXT")
    private String feeling;
    //feeling字段使用TEXT类型

    private Boolean favorite;

    private LocalDate discoverDate;

    @Enumerated(EnumType.STRING)
    private MemoryType type;

    public MemoryItem(){

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public MemoryType getType(){
        return type;
    }

    public void setType(MemoryType type){
        this.type=type;
    }

    public String getFeeling(){
        return feeling;
    }

    public void setFeeling(String feeling){
        this.feeling=feeling;
    }

    public Boolean getFavorite(){
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public LocalDate getDiscoverDate(){
        return discoverDate;
    }
    public void setDiscoverDate(LocalDate discoverDate){
        this.discoverDate=discoverDate;
    }

}
