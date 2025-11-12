package com.strangeTech.MiRent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    @RequestMapping("/login")
    public String login() {
        return "login";  // → src/main/resources/templates/login.html
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";  // → src/main/resources/templates/dashboard.html
    }
}
