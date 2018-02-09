package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.Provinsi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProvinsiRepository extends CrudRepository<Provinsi, String> {

    public List<Provinsi> findAll();
}