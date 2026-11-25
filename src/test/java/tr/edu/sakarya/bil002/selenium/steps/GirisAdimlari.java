package tr.edu.sakarya.bil002.selenium.steps;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.When;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Ozaman;
import io.cucumber.java.tr.Ve;
import tr.edu.sakarya.bil002.selenium.destek.TarayiciBaglami;
import tr.edu.sakarya.bil002.selenium.pages.GirisSayfasi;
import tr.edu.sakarya.bil002.selenium.pages.GuvenliAlanSayfasi;

/**
 * giris.feature adımları. Adım tanımlarında driver.findElement YOK: sadece page metotları çağrılır
 * (POM kuralı). "Eğer ki" adımları için @When (Türkçe anotasyon adı "Eğerki" Türkçe karakter içerir;
 * Cucumber adımı cümleye göre eşlediği için anahtar kelime fark etmez).
 */
public class GirisAdimlari {

    private final GirisSayfasi girisSayfasi;
    private final GuvenliAlanSayfasi guvenliAlan;

    public GirisAdimlari(TarayiciBaglami baglam) {
        this.girisSayfasi = new GirisSayfasi(baglam.surucu());
        this.guvenliAlan = new GuvenliAlanSayfasi(baglam.surucu());
    }

    @Diyelimki("kullanıcı giriş sayfasındadır")
    public void girisSayfasindadir() {
        girisSayfasi.ac();
    }

    @When("kullanıcı adı {string} ve şifre {string} ile giriş yapar")
    public void girisYapar(String kullanici, String sifre) {
        girisSayfasi.girisYap(kullanici, sifre);
    }

    @Ozaman("güvenli alan sayfası açılır")
    public void guvenliAlanAcilir() {
        guvenliAlan.yuklendi();
        assertTrue(guvenliAlan.adres().endsWith("/secure"), guvenliAlan.adres());
        assertEquals("Secure Area", guvenliAlan.baslikMetni());
    }

    @Ve("{string} başarı mesajı görünür")
    public void basariMesajiGorunur(String mesaj) {
        assertEquals(mesaj, guvenliAlan.bildirim());
    }

    @Ozaman("giriş sayfasında kalınır ve {string} hata mesajı görünür")
    public void hataMesajiGorunur(String mesaj) {
        assertAll(
                () -> assertTrue(girisSayfasi.adres().endsWith("/login"), girisSayfasi.adres()),
                () -> assertTrue(girisSayfasi.hataBildirimiMi(), "kırmızı hata kutusu bekleniyordu"),
                () -> assertEquals(mesaj, girisSayfasi.bildirim()));
    }

    @Ve("kullanıcı çıkış yapar")
    public void cikisYapar() {
        guvenliAlan.cikisYap();
    }

    @Ozaman("giriş sayfasına dönülür ve {string} mesajı görünür")
    public void girisSayfasinaDonulur(String mesaj) {
        assertEquals("Login Page", girisSayfasi.sayfaBasligi());
        assertEquals(mesaj, girisSayfasi.bildirim());
    }
}
