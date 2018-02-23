package com.tabeldata.bpr.entity.nasabah;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorValue("B")
public class NasabahBadanUsaha extends Nasabah {

    @Column(name = "nomor_npwp", length = 62)
    private String nomorNpwp;
}
