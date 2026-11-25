package tr.edu.sakarya.bil002.selenium.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import io.cucumber.java.en.When;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Ozaman;
import tr.edu.sakarya.bil002.selenium.destek.TarayiciBaglami;
import tr.edu.sakarya.bil002.selenium.pages.FormElemanlariSayfasi;

/** form_elemanlari.feature adımları (açılır liste ve onay kutuları). */
public class FormElemanlariAdimlari {

    private final FormElemanlariSayfasi sayfa;

    public FormElemanlariAdimlari(TarayiciBaglami baglam) {
        this.sayfa = new FormElemanlariSayfasi(baglam.surucu());
    }

    @Diyelimki("kullanıcı açılır liste sayfasındadır")
    public void acilirListeSayfasindadir() {
        sayfa.acilirListeyiAc();
    }

    @Diyelimki("kullanıcı onay kutuları sayfasındadır")
    public void onayKutulariSayfasindadir() {
        sayfa.onayKutulariniAc();
    }

    @When("kullanıcı listeden {string} seçeneğini seçer")
    public void secenekSecer(String secenek) {
        sayfa.secenekSec(secenek);
    }

    @Ozaman("seçili seçenek {string} olur")
    public void seciliSecenek(String beklenen) {
        assertEquals(beklenen, sayfa.seciliSecenek());
    }

    @Ozaman("{string} seçeneği seçilemez durumdadır")
    public void secenekSecilemez(String secenek) {
        assertFalse(sayfa.secenekEtkinMi(secenek));
    }

    @When("kullanıcı {int}. onay kutusuna tıklar")
    public void onayKutusunaTiklar(int sira) {
        sayfa.onayKutusunaTikla(sira);
    }

    @Ozaman("{int}. onay kutusu {word} olur")
    public void onayKutusuDurumu(int sira, String durum) {
        assertEquals("işaretli".equals(durum), sayfa.onayKutusuIsaretliMi(sira));
    }
}
