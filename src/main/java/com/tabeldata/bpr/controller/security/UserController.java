package com.tabeldata.bpr.controller.security;

import com.tabeldata.bpr.entity.master.UserSecurity;
import com.tabeldata.bpr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/security")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "list"})
    public String listUser(ModelMap params) {
        params.addAttribute("listUsers", userService.findUsers());
        return "/pages/security/user-list";
    }

    @GetMapping(value = "/form")
    public String form(ModelMap params, UserSecurity user) {
        params.addAttribute("pengguna", user);
        params.addAttribute("roles", userService.findUsers());
        return "/pages/security/user-form";
    }
}
