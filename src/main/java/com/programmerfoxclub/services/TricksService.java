package com.programmerfoxclub.services;

import com.programmerfoxclub.repositories.TricksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TricksService {
    private final TricksRepository tricksRepository;

    @Autowired
    public TricksService (TricksRepository tricksRepository) {
        this.tricksRepository = tricksRepository;
    }

    public List<String> getTricks() {
        return tricksRepository.getTricks();
    }
}
