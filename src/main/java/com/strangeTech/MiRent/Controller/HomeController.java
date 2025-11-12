package com.strangeTech.MiRent.Controller;

import com.strangeTech.MiRent.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private HouseService houseService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("houses", houseService.findAll());
        return "home"; // → templates/home.html
    }
}
