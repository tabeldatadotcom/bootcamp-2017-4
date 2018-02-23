package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.nasabah.Nasabah;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NasabahRepository extends CrudRepository<Nasabah, String> {

    List<Nasabah> findAll();
}
