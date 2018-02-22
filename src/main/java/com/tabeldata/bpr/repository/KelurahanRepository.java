package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.wilayah.Kelurahan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KelurahanRepository extends CrudRepository<Kelurahan, String> {

    List<Kelurahan> findAll();
}
