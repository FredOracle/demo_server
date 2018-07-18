package com.example.common.repository;

import com.example.common.entity.base.BaseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository extends PagingAndSortingRepository<BaseEntity, String> {
}
