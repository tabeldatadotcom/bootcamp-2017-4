package com.tabeldata.bpr.entity.master.wilayah;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kelurahan", schema = "wilayah")
@Data
public class Kelurahan {

    @Id
    @GenericGenerator(name = "uuid_kelurahan", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kelurahan")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String kode;
    @Column(nullable = false, length = 150)
    private String nama;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 20)
    private String createdBy;
    @ManyToOne
    @JoinColumn(name = "kecamatan_id", nullable = false)
    private Kecamatan kecamatan;

}
