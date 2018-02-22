package com.tabeldata.bpr.entity.master.wilayah;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "provinsi", schema = "wilayah")
@ToString(exclude = "listKota")
public class Provinsi {

    @Id
    @GenericGenerator(name = "uuid_provinsi", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_provinsi")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;
    @Column(name = "nama", nullable = false, length = 150)
    private String nama;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 20)
    private String createBy;
    @OneToMany(mappedBy = "provinsi")
    private List<KotaKabupaten> listKota = new ArrayList<>();
}
