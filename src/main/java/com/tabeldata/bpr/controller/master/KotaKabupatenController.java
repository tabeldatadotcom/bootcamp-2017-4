package com.tabeldata.bpr.controller.master;

import com.tabeldata.bpr.entity.master.KotaKabupaten;
import com.tabeldata.bpr.service.WilayahService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/kota")
public class KotaKabupatenController {

    private static Logger console = LoggerFactory.getLogger(KotaKabupatenController.class);

    @Autowired
    private WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String listHtml(ModelMap params) {
        params.addAttribute("listKota", wilayahService.findAllKotaKabupaten());
        return "/pages/kota-kabupaten/list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap, KotaKabupaten kota) {
        modelMap.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
        modelMap.addAttribute("kotaKabupaten", kota);
        return "/pages/kota-kabupaten/form";
    }

    @GetMapping("/form/{id}")
    public String formKotaByID(@PathVariable("id") String kodeKota, ModelMap params, RedirectAttributes redirectAttrs) {
        KotaKabupaten kotaKabupatenById = wilayahService.findKotaKabupatenById(kodeKota);
        if (kotaKabupatenById != null) {
            params.addAttribute("kotaKabupaten", kotaKabupatenById);
            params.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
            return "/pages/kota-kabupaten/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/kota/list";
        }
    }

    @PostMapping("/submit")
    public String submitData(@Valid @ModelAttribute KotaKabupaten kota, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        kota.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        kota.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/kota-kabupaten/form";
        }

        this.wilayahService.save(kota);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kota/list";
    }

    @GetMapping("/hapus/{kodeKota}")
    public String deleteData(@PathVariable("kodeKota") String kode, RedirectAttributes redirectAttributes) {
        this.wilayahService.deleteKotaKabupaten(kode);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/kota/list";
    }
}
