package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.aplikasi.Tabungan;
import com.tabeldata.bpr.entity.master.kriteria.ProdukTabungan;
import com.tabeldata.bpr.entity.transaksi.MutasiTabungan;
import com.tabeldata.bpr.repository.AplikasiTabunganRepository;
import com.tabeldata.bpr.repository.MutasiTabunganRepository;
import com.tabeldata.bpr.repository.ProdukTabunganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TabunganService {

    @Autowired
    private AplikasiTabunganRepository tabunganRepository;
    @Autowired
    private ProdukTabunganRepository kriteriaRepository;
    @Autowired
    private MutasiTabunganRepository mutasiRepository;

    public List<Tabungan> findAll() {
        return this.tabunganRepository.findAll();
    }

    public List<ProdukTabungan> findKriteriaProduk() {
        return this.kriteriaRepository.findAll();
    }

    @Transactional
    public Tabungan save(MutasiTabungan mutasi) {
        Tabungan tabungan = mutasi.getTabungan();
        tabungan = this.tabunganRepository.save(tabungan);
        mutasi.setTabungan(tabungan);
        this.mutasiRepository.save(mutasi);
        this.tabunganRepository.updateSaldoTabungan(mutasi.getCredit(), tabungan.getId());
        return tabungan;
    }
}
