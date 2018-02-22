package com.tabeldata.bpr.controller.master.wilayah;

import com.tabeldata.bpr.entity.master.wilayah.Kecamatan;
import com.tabeldata.bpr.entity.master.wilayah.Kelurahan;
import com.tabeldata.bpr.service.WilayahService;
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
@RequestMapping("/kelurahan")
public class KelurahanController {

    @Autowired
    private WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String listHtml(ModelMap params) {
        params.addAttribute("listKelurahan", wilayahService.findAllKelurahan());
        return "/pages/wilayah/kelurahan/list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap, Kelurahan kelurahan) {
        modelMap.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
        modelMap.addAttribute("kelurahan", kelurahan);
        return "/pages/wilayah/kelurahan/form";
    }

    @GetMapping("/form/{id}")
    public String formKotaByID(@PathVariable("id") String kodeKelurahan, ModelMap params, RedirectAttributes redirectAttrs) {
        Kelurahan kelurahanById = wilayahService.findKelurahanById(kodeKelurahan);
        if (kelurahanById != null) {
            params.addAttribute("kelurahan", kelurahanById);
            params.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
            return "/pages/wilayah/kelurahan/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/kelurahan/list";
        }
    }

    @PostMapping("/submit")
    public String submitData(
            @Valid @ModelAttribute Kelurahan kelurahan,
            BindingResult bindingResult,
            ModelMap params,
            RedirectAttributes redirectAttributes) {
        kelurahan.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        kelurahan.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            params.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
            return "/pages/wilayah/kelurahan/form";
        }

        this.wilayahService.save(kelurahan);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kelurahan/list";
    }

    @GetMapping("/hapus/{kodeKelurahan}")
    public String deleteData(@PathVariable("kodeKelurahan") String kode, RedirectAttributes redirectAttributes) {
        this.wilayahService.deleteKelurahanById(kode);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/kecamatan/list";
    }
}
