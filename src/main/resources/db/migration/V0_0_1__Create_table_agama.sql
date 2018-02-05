/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimmaryanto93
 * Created: Feb 5, 2018
 */

create table master_agama(
    kode_agama character varying(255) not null primary key,
    nama_agama character varying(50) not null unique,
    deskripsi character varying (255),
    created_date timestamp not null,
    created_by character varying(50)
);