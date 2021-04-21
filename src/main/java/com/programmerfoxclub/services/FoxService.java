package com.programmerfoxclub.services;

import com.programmerfoxclub.models.Fox;
import com.programmerfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoxService implements FoxServiceInterface {
    private final FoxRepository foxRepository;

    @Autowired
    public FoxService(FoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

    @Override
    public List<Fox> getAllFoxes() {
        return foxRepository.getFoxes();
    }

    @Override
    public void addFox(String name) {
        foxRepository.addFox(name);
    }

    @Override
    public Fox getFoxByName(String name) {
        Optional<Fox> fox = foxRepository.getFoxes().stream().filter(f->f.getName().toLowerCase().equals(name.toLowerCase())).findAny();
        return fox.orElse(null);
    }

    @Override
    public boolean foxDoesExist(String name) {
        if(getFoxByName(name) == null) {
            return false;
        }
        return true;
    }

    @Override
    public void setFoxesFields(String name, String food, String drink) {
        getFoxByName(name).setFood(food);
        getFoxByName(name).setDrink(drink);
    }
}
