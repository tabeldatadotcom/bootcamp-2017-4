package com.tabeldata.bpr.controller.master.wilayah;

import com.tabeldata.bpr.entity.master.wilayah.KotaKabupaten;
import com.tabeldata.bpr.entity.master.wilayah.Provinsi;
import com.tabeldata.bpr.service.WilayahService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/provinsi")
public class ProvinsiController {

    @Autowired
    private WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String listHtml(ModelMap params) {
        params.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
        return "/pages/wilayah/provinsi/list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap, Provinsi provinsi) {
        modelMap.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
        modelMap.addAttribute("provinsi", provinsi);
        return "/pages/wilayah/provinsi/form";
    }

    @GetMapping("/form/{id}")
    public String formKotaByID(@PathVariable("id") String kodeProvinsi, ModelMap params, RedirectAttributes redirectAttrs) {
        Provinsi provinsiById = wilayahService.findProvinsiById(kodeProvinsi);
        if (provinsiById != null) {
            params.addAttribute("provinsi", provinsiById);
            params.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
            return "/pages/wilayah/provinsi/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/provinsi/list";
        }
    }

    @PostMapping("/submit")
    public String submitData(@Valid Provinsi provinsi, BindingResult bindingResult, ModelMap params, RedirectAttributes redirectAttributes) {
        provinsi.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        provinsi.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "/pages/wilayah/provinsi/form";
        }

        this.wilayahService.save(provinsi);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/provinsi/list";
    }

    @GetMapping("/hapus/{kodeProvinsi}")
    public String deleteData(@PathVariable("kodeProvinsi") String kode, RedirectAttributes redirectAttributes) {
        this.wilayahService.deleteProvinsi(kode);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/provinsi/list";
    }
}
