package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.nasabah.Nasabah;
import com.tabeldata.bpr.entity.nasabah.NasabahBadanUsaha;
import com.tabeldata.bpr.entity.nasabah.NasabahPerorangan;
import com.tabeldata.bpr.repository.NasabahBadanUsahaRepository;
import com.tabeldata.bpr.repository.NasabahPeroranganRepository;
import com.tabeldata.bpr.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class NasabahService {

    @Autowired
    private NasabahRepository nasabahRepository;
    @Autowired
    private NasabahPeroranganRepository peroranganRepository;
    @Autowired
    private NasabahBadanUsahaRepository badanUsahaRepository;


    @Transactional
    public Nasabah save(Nasabah nasabah) {
        return this.nasabahRepository.save(nasabah);
    }

    @Transactional
    public NasabahPerorangan save(NasabahPerorangan nasabah) {
        return this.nasabahRepository.save(nasabah);
    }

    @Transactional
    public NasabahBadanUsaha save(NasabahBadanUsaha nasabah) {
        return this.nasabahRepository.save(nasabah);
    }

    @Transactional
    public void delete(Nasabah nasabah) {
        this.nasabahRepository.delete(nasabah);
    }

    public NasabahPerorangan findPeroranganById(String id) {
        return this.peroranganRepository.findOne(id);
    }

    public NasabahBadanUsaha findBadanUsahaById(String id) {
        return this.badanUsahaRepository.findOne(id);
    }


}
