package com.example.daw1_proyecto_final.controller;

import com.example.daw1_proyecto_final.dto.UserDto;
import com.example.daw1_proyecto_final.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/restricted")
    public String restricted(Model model) {
        return "restricted";
    }

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<UserDto> users = manageService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los datos");

        }
        return "manage";

    }

    @GetMapping("/add")
    public String add(Model model) {
        return "manage-add";
    }

}