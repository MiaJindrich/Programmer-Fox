package com.programmerfoxclub.repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Tricks {

    private List<String> tricks;

    public Tricks() {
        this.tricks = new ArrayList<>(Arrays.asList(
                "create repository",
                "write business logic",
                "set dependencies",
                "create endpoints",
                "write HTML",
                "style templates",
                "create rest API"
        ));
    }

    public List<String> getTricks() {
        return tricks;
    }
}
