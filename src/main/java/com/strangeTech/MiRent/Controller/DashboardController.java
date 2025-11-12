package com.strangeTech.MiRent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    @RequestMapping({"/", "/admin", "/admin/dashboard"})
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping({ "/home"})
    public String home() {
        return "home";
    }

}
