package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.Pendidikan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PendidikanRepository extends CrudRepository<Pendidikan, String> {

    public List<Pendidikan> findAll();
}
