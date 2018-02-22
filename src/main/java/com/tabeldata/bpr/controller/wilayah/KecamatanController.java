package com.tabeldata.bpr.controller.wilayah;

import com.tabeldata.bpr.entity.wilayah.Kecamatan;
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
@RequestMapping("/kecamatan")
public class KecamatanController {

    @Autowired
    private WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String listHtml(ModelMap params) {
        params.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
        return "/pages/wilayah/kecamatan/list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap, Kecamatan kecamatan) {
        modelMap.addAttribute("listKota", wilayahService.findAllKotaKabupaten());
        modelMap.addAttribute("kecamatan", kecamatan);
        return "/pages/wilayah/kecamatan/form";
    }

    @GetMapping("/form/{id}")
    public String formKotaByID(@PathVariable("id") String kodeKecamatan, ModelMap params, RedirectAttributes redirectAttrs) {
        Kecamatan kecamatanById = wilayahService.findKecamatanById(kodeKecamatan);
        if (kecamatanById != null) {
            params.addAttribute("kecamatan", kecamatanById);
            params.addAttribute("listKota", wilayahService.findAllKotaKabupaten());
            return "/pages/wilayah/kecamatan/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/kecamatan/list";
        }
    }

    @PostMapping("/submit")
    public String submitData(
            @Valid @ModelAttribute Kecamatan kecamatan,
            BindingResult bindingResult,
            ModelMap params,
            RedirectAttributes redirectAttributes) {
        kecamatan.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        kecamatan.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            params.addAttribute("listKota", wilayahService.findAllKotaKabupaten());
            return "/pages/wilayah/kecamatan/form";
        }

        this.wilayahService.save(kecamatan);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kecamatan/list";
    }

    @GetMapping("/hapus/{kodeKecamatan}")
    public String deleteData(@PathVariable("kodeKecamatan") String kode, RedirectAttributes redirectAttributes) {
        this.wilayahService.deleteKecamatanById(kode);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/kecamatan/list";
    }
}
