package com.programmerfoxclub.repositories;

import com.programmerfoxclub.models.Fox;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoxRepository {

    private final Foxes foxes;

    public FoxRepository(Foxes foxes) {
        this.foxes = foxes;
    }

    public List<Fox> getFoxes() {
        return foxes.getFoxes();
    }

    public void addFox(String name) {
        foxes.addFox(name);
    }
}
