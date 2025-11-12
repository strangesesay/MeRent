package com.strangeTech.MiRent.Controller;


import com.strangeTech.MiRent.Service.AdminService;
import com.strangeTech.MiRent.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/admins")
public class AdminController {
    @Autowired
    private AdminService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("admins", service.findAll());
        return "admin-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newForm() {
        return "admin-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("admin", service.findById(id));
        return "admin-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String username,
                       @RequestParam String password) {
        Admin admin = id != null ? service.findById(id) : new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        service.save(admin);
        return "redirect:/admin/admins";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/admin/admins";
    }
}
