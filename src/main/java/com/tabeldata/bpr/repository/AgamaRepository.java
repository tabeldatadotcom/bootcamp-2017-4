package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.Agama;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgamaRepository extends CrudRepository<Agama, String> {
    public List<Agama> findAll();
}
