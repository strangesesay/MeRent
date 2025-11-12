package com.strangeTech.MiRent.Controller;


import com.strangeTech.MiRent.Service.UserService;
import com.strangeTech.MiRent.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", service.findAll());
        return "user-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newForm() {
        return "user-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "user-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String username,
                       @RequestParam String email,
                       @RequestParam String password) {
        AppUser user = id != null ? service.findById(id) : new AppUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        service.save(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/admin/users";
    }
}
