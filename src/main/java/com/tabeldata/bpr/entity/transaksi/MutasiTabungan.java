package com.tabeldata.bpr.entity.transaksi;

import com.tabeldata.bpr.entity.aplikasi.Tabungan;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "mutasi_tabungan", schema = "transaksi")
public class MutasiTabungan {

    @Id
    @GenericGenerator(name = "uuid_mutasi", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_mutasi")
    @Column(nullable = false, unique = true, length = 64)
    private String id;

    @ManyToOne
    @JoinColumn(name = "tabungan_id", nullable = false)
    private Tabungan tabungan;

    @Column(name = "debet", nullable = false)
    private BigDecimal debet;

    @Column(name = "credit", nullable = false)
    private BigDecimal credit;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @Column(name = "tanggal_transaksi", nullable = false)
    private Date tanggal;

    @Lob
    private String keterangan;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by")
    private String cratedBy;
}
