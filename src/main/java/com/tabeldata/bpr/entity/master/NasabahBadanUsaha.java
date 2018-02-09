package com.tabeldata.bpr.entity.master;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NasabahBadanUsaha extends Nasabah {

    @Column(name = "nomor_npwp", length = 62)
    private String nomorNpwp;
}
