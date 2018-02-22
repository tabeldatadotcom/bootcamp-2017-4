package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.wilayah.Kelurahan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KelurahanRepository extends CrudRepository<Kelurahan, String> {

    List<Kelurahan> findAll();

    @Modifying
    @Query("update Kelurahan kel set kel.nama = ?1, kel.kecamatan.id = ?2 where kel.id = ?3")
    int updateNamaKelurahanAndKecamatanId(String namaKelurahan, String kecamatanId, String kelurahanId);
}
