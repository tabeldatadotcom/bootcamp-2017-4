package com.tabeldata.bpr;

import com.tabeldata.bpr.entity.master.*;
import com.tabeldata.bpr.entity.master.wilayah.KotaKabupaten;
import com.tabeldata.bpr.entity.master.wilayah.Provinsi;
import com.tabeldata.bpr.service.*;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AplikasiBprApplicationTests extends TestCase {

    @Autowired
    private AgamaService agamaService;
    @Autowired
    private PendidikanService pendidikanService;
    @Autowired
    private WilayahService wilayahService;
    @Autowired
    private UserService userService;
    @Autowired
    private NasabahService nasabahService;

    @Test
    public void contextLoads() {
    }

    @Ignore
    @Test
    public void testSimpanAgama() {
        Agama islam = new Agama(null, "Islam", "Muslim", Timestamp.valueOf(LocalDateTime.now()), "admin");
        agamaService.save(islam);

        Agama kristen = new Agama(null, "Kristen", "Kristen Protestan", Timestamp.valueOf(LocalDateTime.now()), "admin");
        agamaService.save(kristen);

        List<Agama> daftarAgama = agamaService.findAll();
        assertEquals(daftarAgama.size(), 2);

        islam = agamaService.findByNama("Islam");
        assertNotNull(islam);

        List<Agama> daftarAgamaByNamaOrDesk =
                agamaService.mencariBerdasarkanNamaAtauDeskripsi("Islam");
        assertEquals(daftarAgamaByNamaOrDesk.size(), 1);

        Agama islam2 = new Agama();
        islam2.setId(islam.getId());
        islam2.setNama("ISIS");
        islam2.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        agamaService.save(islam2);
        islam2 = agamaService.findById(islam.getId());

        agamaService.updateById(kristen.getId(), "Budha", "Chinese");
        kristen = agamaService.findById(kristen.getId());
        assertEquals(kristen.getNama(), "Budha");
        assertEquals(kristen.getDeskripsi(), "Chinese");

        assertEquals(islam2.getNama(), "ISIS");

        agamaService.deleteByName("i");

        agamaService.delete(daftarAgama);
        daftarAgama = agamaService.findAll();
        assertEquals(daftarAgama.size(), 0);
    }

    @Test
    public void testPendidikan() {
        List<Pendidikan> daftarPendidikan = pendidikanService.findAll();
        assertEquals(daftarPendidikan.size(), 3);
    }

    @Test
    public void testKotaProvinsi() {
        List<Provinsi> daftarWilayah = this.wilayahService.findAllProvinsi();
        assertEquals(3, daftarWilayah.size());

        Provinsi jawaBarat = this.wilayahService.findProvinsiById("001");
        assertNotNull(jawaBarat);
        assertEquals(1, jawaBarat.getListKota().size());

        List<KotaKabupaten> daftarKota = this.wilayahService.findAllKotaKabupaten();
        assertEquals(4, daftarKota.size());
    }

    @Test
    public void testUser() {

        List<RoleSecurity> roles = this.userService.listRole();
        assertEquals(2, roles.size());

        List<UserSecurity> users = this.userService.findUsers();
        assertEquals(2, users.size());

        UserSecurity admin = this.userService.findByUsername("admin");
        assertNotNull(admin);
        assertEquals(2, admin.getListRole().size());

        UserSecurity dimas = this.userService.findByUsername("dimas");
        assertNotNull(dimas);
        assertEquals(1, dimas.getListRole().size());

    }

    @Test
    public void testSimpanNasabah() {
        NasabahPerorangan dimas = new NasabahPerorangan();
        dimas.setNamaLengkap("Dimas Maryanto");
        dimas.setJenisKelamin("L");
        dimas.setNomorIdentitas("6212423408234");
        dimas.setAlamat("Jl. Bukit indah no B8");
        dimas = this.nasabahService.save(dimas);
        assertNotNull(dimas.getId());

        dimas = this.nasabahService.findPeroranganById(dimas.getId());
        assertNotNull(dimas);
        Nasabah bukan = this.nasabahService.findBadanUsahaById(dimas.getId());
        assertNull(bukan);

        NasabahBadanUsaha tabeldata = new NasabahBadanUsaha();
        tabeldata.setNamaLengkap("Tabel Data Informatika");
        tabeldata.setNomorNpwp("1242421423");
        tabeldata.setAlamat("Jl. margawangi raya no 8");
        tabeldata = this.nasabahService.save(tabeldata);
        assertNotNull(tabeldata.getId());
//        this.nasabahService.delete(tabeldata);

    }

}
