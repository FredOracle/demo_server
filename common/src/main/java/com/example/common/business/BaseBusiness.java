package com.example.common.business;

import com.example.common.entity.base.BaseEntity;
import com.example.common.repository.BaseRepository;
import org.apache.commons.collections.IteratorUtils;

import javax.annotation.Resource;
import java.util.List;

public abstract class BaseBusiness<T extends BaseEntity, String> {

    @Resource
    private BaseRepository repository;

    public T create(T entity){
        return repository.save(entity);
    }

    public T update(T entity){
        return repository.save(entity);
    }

    public void deleteById(java.lang.String id){
        repository.deleteById(id);
    }

    public T findById(java.lang.String id){
        return (T) repository.findById(id).get();
    }

    public List<T> findAll(){
        return IteratorUtils.toList(repository.findAll().iterator());
    }

}
