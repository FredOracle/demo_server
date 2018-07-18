package com.example.demo.business;

import com.example.demo.entity.Stone;
import com.example.demo.repository.StoneRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class StoneBusinessImplTest {

    StoneRepository repository = mock(StoneRepository.class);


    Stone mockedStone = mock(Stone.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        Stone stone = repository.save(mockedStone);

        System.out.println(stone.getPassword());

    }


    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findOneById() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAllByFlag() {
    }
}