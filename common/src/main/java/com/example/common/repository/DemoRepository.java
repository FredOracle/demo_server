package com.example.common.repository;

import com.example.common.entity.Demo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DemoRepository extends PagingAndSortingRepository<Demo, String> {
}
