package com.strio.receipeapp.repository;

import com.strio.receipeapp.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class UnitOfMeasureRepositoryIT {

    @Autowired
    public UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void findByDescription(){
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("TeaSpoon");
        assertEquals("TeaSpoon", unitOfMeasure.get().getDescription());
    }
}