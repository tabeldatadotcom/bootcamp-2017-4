package com.tabeldata.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HaloController {

    @GetMapping(value = {"/", "/index"})
    public String haloController() {
        return "/pages/index";
    }
}
