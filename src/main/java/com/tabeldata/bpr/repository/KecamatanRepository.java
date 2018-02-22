package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.wilayah.Kecamatan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KecamatanRepository extends CrudRepository<Kecamatan, String> {

    List<Kecamatan> findAll();
}
