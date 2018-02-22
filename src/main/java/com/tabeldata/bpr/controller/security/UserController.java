package com.tabeldata.bpr.controller.security;

import com.tabeldata.bpr.entity.security.UserSecurity;
import com.tabeldata.bpr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        params.addAttribute("roles", userService.listRole());
        return "/pages/security/user-form";
    }

    @GetMapping(value = "/form/{kodeUser}")
    public String formById(
            ModelMap params,
            @PathVariable("kodeUser") String kodeUser,
            RedirectAttributes redirectAttributes) {
        UserSecurity userById = userService.findById(kodeUser);
        if (userById != null) {
            params.addAttribute("pengguna", userById);
            params.addAttribute("roles", userService.listRole());
            return "/pages/security/user-form";
        } else {
            redirectAttributes.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/user/security/list";
        }
    }

    @PostMapping("/submit")
    public String submitData(
            @Valid @ModelAttribute UserSecurity user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            ModelMap params) {
        user.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        user.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            params.addAttribute("roles", userService.listRole());
            return "/pages/security/user-form";
        }

        this.userService.save(user);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/user/security/list";
    }
}
