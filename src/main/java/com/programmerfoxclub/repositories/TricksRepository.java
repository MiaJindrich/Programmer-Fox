package com.programmerfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TricksRepository {

    private final Tricks tricks;

    public TricksRepository (Tricks tricks) {
        this.tricks = tricks;
    }

    public List<String> getTricks() {
        return tricks.getTricks();
    }
}
