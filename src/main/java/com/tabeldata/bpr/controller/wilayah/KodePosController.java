package com.tabeldata.bpr.controller.wilayah;

import com.tabeldata.bpr.service.WilayahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kodepos")
public class KodePosController {


    @Autowired
    private WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String listHtml(ModelMap params) {
        params.addAttribute("listKodePos", wilayahService.findKodepos());
        return "/pages/wilayah/kodepos/list";
    }
}
