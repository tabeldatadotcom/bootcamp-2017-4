package com.tabeldata.bpr.entity.nasabah;

import com.tabeldata.bpr.entity.master.Agama;
import com.tabeldata.bpr.entity.master.Pendidikan;
import com.tabeldata.bpr.entity.wilayah.KodePos;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NasabahPerorangan extends Nasabah {

    @Column(name = "nomor_identitas", length = 64)
    private String nomorIdentitas;

    @Column(name = "jenis_kelamin", length = 1)
    private String jenisKelamin;

    @OneToOne
    @JoinColumn(name = "agama_id")
    private Agama agama;

    @Column(name = "alamat_domisili")
    private String alamatDomisili;

    @OneToOne
    @JoinColumn(name = "kodepos_domisili")
    private KodePos domisili;

    @OneToOne
    @JoinColumn(name = "pendidikan_terakhir")
    private Pendidikan pendidikanTerakhir;
}
