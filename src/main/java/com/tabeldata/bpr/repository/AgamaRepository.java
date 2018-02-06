package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.Agama;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgamaRepository extends CrudRepository<Agama, String> {
    public List<Agama> findAll();

    public Agama findByNama(String namaAgama);

    public List<Agama> findByNamaOrDeskripsi(String nama, String deskripsi);
}
