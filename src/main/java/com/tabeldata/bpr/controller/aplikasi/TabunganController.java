package com.tabeldata.bpr.controller.aplikasi;

import com.tabeldata.bpr.entity.aplikasi.Tabungan;
import com.tabeldata.bpr.entity.transaksi.MutasiTabungan;
import com.tabeldata.bpr.service.NasabahService;
import com.tabeldata.bpr.service.TabunganService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/aplikasi/tabungan")
public class TabunganController {

    private final static Logger console = LoggerFactory.getLogger(TabunganController.class);

    @Autowired
    private TabunganService tabunganService;
    @Autowired
    private NasabahService nasabahService;

    @GetMapping(value = {"/", "/list"})
    public String listTabungan(ModelMap params) {
        params.addAttribute("listTabungan", tabunganService.findAll());
        return "/pages/aplikasi/tabungan/list";
    }

    @GetMapping("/form")
    public String formTabungan(@ModelAttribute Tabungan tabungan, ModelMap params) {
        params.addAttribute("tabungan", tabungan);
        params.addAttribute("listNasabah", nasabahService.findAll());
        params.addAttribute("listProduct", tabunganService.findKriteriaProduk());
        return "/pages/aplikasi/tabungan/form";
    }

    @PostMapping("/submit")
    public String submitTabungan(
            @Valid @ModelAttribute Tabungan tabungan, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest, ModelMap params) {
        String saldoAwalText = httpServletRequest.getParameter("setoranAwal");
        BigDecimal saldoAwal = saldoAwalText != null && !saldoAwalText.isEmpty() ?
                new BigDecimal(httpServletRequest.getParameter("setoranAwal")) :
                BigDecimal.ZERO;

        tabungan.setCreatedBy("admin");
        tabungan.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        tabungan.setOpening(Date.valueOf(LocalDate.now()));
        tabungan.setSaldo(BigDecimal.ZERO);

        MutasiTabungan setoranAwal = new MutasiTabungan();
        setoranAwal.setCratedBy(tabungan.getCreatedBy());
        setoranAwal.setCreatedDate(tabungan.getCreatedDate());
        setoranAwal.setTanggal(tabungan.getOpening());

        setoranAwal.setCredit(saldoAwal);
        setoranAwal.setDebet(BigDecimal.ZERO);
        setoranAwal.setSaldo(setoranAwal.getCredit());
        setoranAwal.setKeterangan("SETORAN_TABUNGAN");
        setoranAwal.setTabungan(tabungan);

        if (bindingResult.hasErrors()) {
            params.addAttribute("listNasabah", nasabahService.findAll());
            params.addAttribute("listProduct", tabunganService.findKriteriaProduk());
            return "pages/aplikasi/tabungan/form";
        }

        this.tabunganService.save(setoranAwal);
        return "redirect:/aplikasi/tabungan/list";
    }

    @GetMapping("/detail/{id}")
    public String detailTabungan(@PathVariable String id, ModelMap params) {
        Tabungan tabungan = this.tabunganService.findById(id);
        if (tabungan != null) {
            params.addAttribute("tabungan", tabungan);
            params.addAttribute("nasabah", tabungan.getNasabah());
            return "/pages/aplikasi/tabungan/detail-tabungan";
        } else {
            return "redirect:/aplikasi/tabungan/list";
        }
    }
}
