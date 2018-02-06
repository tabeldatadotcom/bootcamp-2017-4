package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.KotaKabupaten;
import com.tabeldata.bpr.entity.master.Provinsi;
import com.tabeldata.bpr.repository.KotaKabupatenRepository;
import com.tabeldata.bpr.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WilayahService {

    @Autowired
    private KotaKabupatenRepository kotaRepository;
    @Autowired
    private ProvinsiRepository propRepository;

    public List<Provinsi> findAllProvinsi(){
        return this.propRepository.findAll();
    }

    public List<KotaKabupaten> findAllKotaKabupaten(){
        return this.kotaRepository.findAll();
    }
}
