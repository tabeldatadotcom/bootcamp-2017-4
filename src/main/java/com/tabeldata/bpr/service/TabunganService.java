package com.tabeldata.bpr.service;

import com.tabeldata.bpr.repository.AplikasiTabunganRepository;
import com.tabeldata.bpr.repository.MutasiTabunganRepository;
import com.tabeldata.bpr.repository.ProdukTabunganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TabunganService {

    @Autowired
    private AplikasiTabunganRepository tabunganRepository;
    @Autowired
    private ProdukTabunganRepository kriteriaRepository;
    @Autowired
    private MutasiTabunganRepository mutasiRepository;
}
