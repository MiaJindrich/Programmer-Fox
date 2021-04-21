package com.programmerfoxclub.services;

import com.programmerfoxclub.models.Fox;

import java.util.List;

public interface FoxServiceInterface {
    public List<Fox> getAllFoxes();
    public void addFox(String name);
    public Fox getFoxByName(String name);
    public boolean foxDoesExist(String name);
    public void setFoxesFields(String name, String food, String drink);
}
