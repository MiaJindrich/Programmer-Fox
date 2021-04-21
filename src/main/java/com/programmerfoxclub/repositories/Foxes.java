package com.programmerfoxclub.repositories;

import com.programmerfoxclub.models.Fox;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Foxes {

    private List<Fox> foxes = new ArrayList<>();

    public Foxes() {
        this.foxes = new ArrayList<>(Arrays.asList(
            new Fox("Mia", new ArrayList<>(), "melons","juice")
        ));
    }

    public List<Fox> getFoxes() {
        return foxes;
    }

    public void addFox(String name) {
        foxes.add(new Fox(name, new ArrayList<>(), "dry food", "water"));
    }
}
