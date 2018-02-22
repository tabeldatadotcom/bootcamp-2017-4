package com.tabeldata.bpr.entity.aplikasi;

import com.tabeldata.bpr.entity.master.KriteriaProdukTabungan;
import com.tabeldata.bpr.entity.nasabah.Nasabah;
import com.tabeldata.bpr.entity.transaksi.MutasiTabungan;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tabungan", schema = "aplikasi")
public class Tabungan {

    @Id
    @GenericGenerator(strategy = "uuid2", name = "uuid_tabungan")
    @GeneratedValue(generator = "uuid_tabungan")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;

    @Column(name = "nomor_rekening", nullable = false, unique = true, length = 15)
    private String nomorRekening;

    @OneToOne
    @JoinColumn(name = "nasabah_id", nullable = false)
    private Nasabah nasabah;

    @Column(name = "tanggal_opening", nullable = false)
    private Date opening;

    @Column(nullable = false)
    private BigDecimal saldo;

    @OneToOne
    @JoinColumn(name = "kriteria_id", nullable = false)
    private KriteriaProdukTabungan kriteriaProduk;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(mappedBy = "tabungan")
    private List<MutasiTabungan> listMutasi = new ArrayList<>();

}
