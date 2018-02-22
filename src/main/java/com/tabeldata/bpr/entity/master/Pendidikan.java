package com.tabeldata.bpr.entity.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "pendidikan", schema = "master")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pendidikan {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 5)
    private String id;

    @Column(name = "nama", nullable = false, length = 150)
    private String nama;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", length = 20)
    private String createdBy;

}
