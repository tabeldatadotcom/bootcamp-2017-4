package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.Agama;
import com.tabeldata.bpr.repository.AgamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AgamaService {

    @Autowired
    private AgamaRepository repo;

    @Transactional
    public Agama save(Agama x) {
        return repo.save(x);
    }

    public Agama findById(String kode) {
        return repo.findOne(kode);
    }

    public List<Agama> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void delete(Agama x) {
        this.repo.delete(x);
    }

    @Transactional
    public void delete(String x) {
        this.repo.delete(x);
    }

    @Transactional
    public void delete(List<Agama> list) {
        this.repo.delete(list);
    }

    public Agama findByNama(String nama) {
        return this.repo.findByNama(nama);
    }

    public List<Agama> mencariBerdasarkanNamaAtauDeskripsi(String input) {
        return this.repo.findByNamaOrDeskripsi(input, input);
    }

    @Transactional
    public void updateById(String id, String nama, String description) {
        this.repo.updateNamaAndDescription(id, nama, description);
    }

    @Transactional
    public void deleteByName(String name) {
        this.repo.deleteByLikeName(name);
    }
}
