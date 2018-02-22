package com.tabeldata.bpr.entity.master;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "kriteria_tabungan", schema = "master")
public class KriteriaProdukTabungan {

    @Id
    @GenericGenerator(name = "uuid_kriteri_tabungan", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kriteri_tabungan")
    @Column(nullable = false, unique = true, length = 64)
    private String id;

    @Column(nullable = false, unique = true, length = 50)
    private String kode;

    @Column(nullable = false, length = 150)
    private String nama;

    @Column(name = "suku_bunga", nullable = false, scale = 2, length = 3)
    private Double sukuBunga;

    @Column(name = "setoran_awal", nullable = false)
    private BigDecimal setoranAwal;

    @Column(name = "biaya_administrasi", nullable = false)
    private BigDecimal biayaAdministrasi;

    @Column(name = "is_active", nullable = false)
    private boolean active;

}
