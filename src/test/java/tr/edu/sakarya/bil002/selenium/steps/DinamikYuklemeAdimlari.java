package tr.edu.sakarya.bil002.selenium.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.When;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Ozaman;
import io.cucumber.java.tr.Ve;
import tr.edu.sakarya.bil002.selenium.destek.TarayiciBaglami;
import tr.edu.sakarya.bil002.selenium.pages.DinamikYuklemeSayfasi;

/** dinamik_yukleme.feature adımları. */
public class DinamikYuklemeAdimlari {

    private final DinamikYuklemeSayfasi sayfa;

    public DinamikYuklemeAdimlari(TarayiciBaglami baglam) {
        this.sayfa = new DinamikYuklemeSayfasi(baglam.surucu());
    }

    @Diyelimki("kullanıcı {int} numaralı dinamik yükleme örneğini açar")
    public void ornegiAcar(int ornekNo) {
        sayfa.ac(ornekNo);
    }

    @Ve("henüz hiçbir sonuç metni görünmez")
    public void sonucGorunmez() {
        assertFalse(sayfa.sonucGorunuyorMu());
    }

    @When("kullanıcı Start düğmesine basar")
    public void startaBasar() {
        sayfa.baslat();
    }

    @Ozaman("yükleme bittikten sonra {string} metni görünür")
    public void metinGorunur(String beklenen) {
        assertEquals(beklenen, sayfa.sonucMetni());              // explicit wait içerde
        assertTrue(sayfa.yuklemeBittiMi(), "yükleme göstergesi kaybolmalı");
    }
}
