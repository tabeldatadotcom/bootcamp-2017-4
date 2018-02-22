package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.wilayah.Kecamatan;
import com.tabeldata.bpr.entity.master.wilayah.Kelurahan;
import com.tabeldata.bpr.entity.master.wilayah.KotaKabupaten;
import com.tabeldata.bpr.entity.master.wilayah.Provinsi;
import com.tabeldata.bpr.repository.KecamatanRepository;
import com.tabeldata.bpr.repository.KelurahanRepository;
import com.tabeldata.bpr.repository.KotaKabupatenRepository;
import com.tabeldata.bpr.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private KecamatanRepository kecamatanRepository;
    @Autowired
    private KelurahanRepository kelurahanRepository;

    public List<Provinsi> findAllProvinsi() {
        return this.propRepository.findAll();
    }

    @Transactional
    public KotaKabupaten save(KotaKabupaten kota) {
        return this.kotaRepository.save(kota);
    }

    @Transactional
    public Provinsi save(Provinsi provinsi) {
        return this.propRepository.save(provinsi);
    }

    @Transactional
    public void deleteKotaKabupaten(String id) {
        this.kotaRepository.delete(id);
    }

    @Transactional
    public void deleteProvinsi(String id) {
        this.propRepository.delete(id);
    }

    public KotaKabupaten findKotaKabupatenById(String id) {
        return this.kotaRepository.findOne(id);
    }

    public List<KotaKabupaten> findAllKotaKabupaten() {
        return this.kotaRepository.findAll();
    }

    public Provinsi findProvinsiById(String id) {
        return this.propRepository.findOne(id);
    }

    public List<Kecamatan> findAllKecamatan() {
        return this.kecamatanRepository.findAll();
    }

    public Kecamatan findKecamatanById(String id) {
        return this.kecamatanRepository.findOne(id);
    }

    @Transactional
    public Kecamatan save(Kecamatan kecamatan) {
        return this.kecamatanRepository.save(kecamatan);
    }

    @Transactional
    public void deleteKecamatanById(String id) {
        this.kecamatanRepository.delete(id);
    }

    public List<Kelurahan> findAllKelurahan() {
        return this.kelurahanRepository.findAll();
    }

    @Transactional
    public Kelurahan save(Kelurahan kelurahan) {
        return this.kelurahanRepository.save(kelurahan);
    }

    public Kelurahan findKelurahanById(String id) {
        return this.kelurahanRepository.findOne(id);
    }

    @Transactional
    public void deleteKelurahanById(String id) {
        this.kelurahanRepository.delete(id);
    }
}
