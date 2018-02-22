package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.wilayah.Provinsi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProvinsiRepository extends CrudRepository<Provinsi, String> {

     List<Provinsi> findAll();
}
