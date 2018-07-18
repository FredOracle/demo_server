package com.example.demo.repository;

import com.example.demo.entity.Stone;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StoneRepository extends PagingAndSortingRepository<Stone, String> {

    public List<Stone> findAllByFlag(Integer flag);
}
