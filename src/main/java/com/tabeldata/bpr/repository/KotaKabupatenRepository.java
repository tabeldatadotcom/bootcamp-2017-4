package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.wilayah.KotaKabupaten;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KotaKabupatenRepository extends CrudRepository<KotaKabupaten, String> {
    List<KotaKabupaten> findAll();
}
