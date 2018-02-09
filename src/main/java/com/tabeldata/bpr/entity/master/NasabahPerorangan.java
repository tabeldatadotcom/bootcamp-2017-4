package com.tabeldata.bpr.entity.master;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NasabahPerorangan extends Nasabah {

    @Column(name = "nomor_identitas", length = 64)
    private String nomorIdentitas;

    @Column(name = "jenis_kelamin", length = 1)
    private String jenisKelamin;
}
