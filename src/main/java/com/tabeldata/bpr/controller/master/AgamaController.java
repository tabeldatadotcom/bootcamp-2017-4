package com.tabeldata.bpr.controller.master;

import com.tabeldata.bpr.service.AgamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agama")
public class AgamaController {

    @Autowired
    private AgamaService agamaService;

    /**
     * localhost:8080/agama/ atau localhost:8080/agama/list
     * @return
     */
    @GetMapping(value = {"/", "/list"})
    public String listAgama(ModelMap params){
        params.addAttribute("listAgama", agamaService.findAll());
        return "/pages/agama/list";
    }
}
