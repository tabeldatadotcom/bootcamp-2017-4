package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.kriteria.ProdukTabungan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdukTabunganRepository extends CrudRepository<ProdukTabungan, String> {
    List<ProdukTabungan> findAll();
}
