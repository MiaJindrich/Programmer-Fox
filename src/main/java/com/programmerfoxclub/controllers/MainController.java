package com.programmerfoxclub.controllers;

import com.programmerfoxclub.models.Fox;
import com.programmerfoxclub.services.FoxService;
import com.programmerfoxclub.services.TricksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    private final FoxService foxService;
    private final TricksService tricksService;

    @Autowired
    public MainController(FoxService foxService, TricksService tricksService) {
        this.foxService = foxService;
        this.tricksService = tricksService;
    }

    @GetMapping("/")
    public String main(Model model, @RequestParam(required = false) String name, @RequestParam(required = false) String info) {
        if(name == null) {
            return "redirect:/login";
        }
        if(foxService.foxDoesExist(name)) {
            model.addAttribute("name", name);
               if(info != null && info.equals("true")) {
                   model.addAttribute("fox", foxService.getFoxByName(name));
                   model.addAttribute("tricks", tricksService.getTricks());
            }
            return "index";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name) {
        if(!foxService.foxDoesExist(name)) {
            foxService.addFox(name);
        }
        return "redirect:/?name=" + name;
    }

    @GetMapping("/nutritionstore")
    public String nutritionStore(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "nutrition";
    }

    @PostMapping("/nutritionstore")
    public String nutritionStore(@RequestParam String name, @RequestParam String food, @RequestParam String drink) {
        foxService.setFoxesFields(name, food, drink);
        return "redirect:/?name="+name+"&info=true";
    }

    @GetMapping("/trickcenter")
    public String trickCenter(Model model, @RequestParam String name) {
        List<String> learnedTricks = foxService.getFoxByName(name).getTricks();
        List<String> allTricks = tricksService.getTricks();
        allTricks.removeAll(learnedTricks);
        model.addAttribute("name", name);
        model.addAttribute("tricks", allTricks);
        return "tricks";
    }

    @PostMapping("/trickcenter")
    public String trickCenter(@RequestParam String name, @RequestParam String trick) {
        foxService.getFoxByName(name).learnTrick(trick);
        return "redirect:/?name="+name+"&info=true";
    }
}


