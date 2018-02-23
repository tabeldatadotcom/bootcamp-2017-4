package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.transaksi.MutasiTabungan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MutasiTabunganRepository extends CrudRepository<MutasiTabungan, String> {
    List<MutasiTabungan> findAll();
}
