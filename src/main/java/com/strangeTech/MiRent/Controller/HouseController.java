package com.strangeTech.MiRent.Controller;


import com.strangeTech.MiRent.Service.HouseService;
import com.strangeTech.MiRent.Service.UserService;
import com.strangeTech.MiRent.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/houses")
public class HouseController {
    @Autowired
    private HouseService service;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("houses", service.findAll());
        return "house-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newForm(Model model) {
        model.addAttribute("users", userService.findAll());
        return "house-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("house", service.findById(id));
        model.addAttribute("users", userService.findAll());
        return "house-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String address,
                       @RequestParam double price,
                       @RequestParam String description
                       ) {
        House house = id != null ? service.findById(id) : new House();
        house.setAddress(address);
        house.setPrice(price);
        house.setDescription(description);
        service.save(house);
        return "redirect:/admin/houses";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/admin/houses";
    }

}
