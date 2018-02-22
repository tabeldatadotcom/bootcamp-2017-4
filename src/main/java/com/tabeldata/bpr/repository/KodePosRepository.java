package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.wilayah.KodePos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KodePosRepository extends CrudRepository<KodePos, String> {

    List<KodePos> findAll();
}
