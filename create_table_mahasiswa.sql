create table master_mahasiswa(
    nim bigint primary key unique not null,
    nama character varying(50) not null,
    jenis_kelamin character(1) not null,
	tanggal_lahir date not null
)
