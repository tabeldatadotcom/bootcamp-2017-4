package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.wilayah.KodePos;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KodePosRepository extends CrudRepository<KodePos, String> {

    List<KodePos> findAll();

    KodePos findByKelurahanId(String kelurahanId);

    @Modifying
    @Query("update KodePos pos set pos.kodePos = ?1 where pos.id = ?2")
    int updateKodePos(Integer kodePos, String id);
}
