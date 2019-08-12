package com.ripjava.demo.dao;

import com.ripjava.demo.model.Pet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PetRepositoryTest {

    @Autowired
    private  PetRepository petRepository;

    @BeforeEach
    public void initData(){
        Pet p = new Pet();
        p.setName("test");
        p.setAge(123);
        p.setPlanId("12");
        p.setId(1L);
        petRepository.save(p);
    }
    @Test
    public void test_planIdEquals(){
        Pet pet = petRepository.findPetName("12");

        assertEquals(1L, pet.getId());
    }
}
