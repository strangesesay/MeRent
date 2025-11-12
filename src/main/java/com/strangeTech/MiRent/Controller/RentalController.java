package com.strangeTech.MiRent.Controller;

import com.strangeTech.MiRent.Service.HouseService;
import com.strangeTech.MiRent.Service.RentalService;
import com.strangeTech.MiRent.Service.UserService;
import com.strangeTech.MiRent.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin/rentals")
public class RentalController {
    @Autowired
    private RentalService service;
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("rentals", service.findAll());
        return "rental-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newForm(Model model) {
        model.addAttribute("houses", houseService.findAll());
        model.addAttribute("users", userService.findAll());
        return "rental-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("rental", service.findById(id));
        model.addAttribute("houses", houseService.findAll());
        model.addAttribute("users", userService.findAll());
        return "rental-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam Long houseId,
                       @RequestParam Long tenantId,
                       @RequestParam String startDate,
                       @RequestParam(required = false) String endDate) {
        Rental rental = id != null ? service.findById(id) : new Rental();
        rental.setHouse(houseService.findById(houseId));
        rental.setTenant(userService.findById(tenantId));
        rental.setStartDate(LocalDate.parse(startDate));
        rental.setEndDate(endDate != null ? LocalDate.parse(endDate) : null);
        service.save(rental);
        return "redirect:/admin/rentals";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/admin/rentals";
    }

}
