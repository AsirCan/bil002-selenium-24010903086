package tr.edu.sakarya.bil002.selenium.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tr.edu.sakarya.bil002.selenium.destek.TarayiciBaglami;

/** Page Object: /dropdown (açılır liste) ve /checkboxes (onay kutuları) sayfaları. */
public class FormElemanlariSayfasi extends TemelSayfa {

    private static final By ACILIR_LISTE = By.id("dropdown");
    private static final By ONAY_KUTULARI = By.cssSelector("#checkboxes input[type='checkbox']");

    public FormElemanlariSayfasi(WebDriver surucu) {
        super(surucu);
    }

    public FormElemanlariSayfasi acilirListeyiAc() {
        surucu.get(TarayiciBaglami.TEMEL_ADRES + "/dropdown");
        gorunurOlunca(ACILIR_LISTE);
        return this;
    }

    public FormElemanlariSayfasi onayKutulariniAc() {
        surucu.get(TarayiciBaglami.TEMEL_ADRES + "/checkboxes");
        gorunurOlunca(ONAY_KUTULARI);
        return this;
    }

    public void secenekSec(String gorunenMetin) {
        new Select(gorunurOlunca(ACILIR_LISTE)).selectByVisibleText(gorunenMetin);
    }

    public String seciliSecenek() {
        return new Select(gorunurOlunca(ACILIR_LISTE)).getFirstSelectedOption().getText();
    }

    /** Seçenek seçilebilir mi? ("Please select an option" devre dışıdır.) */
    public boolean secenekEtkinMi(String gorunenMetin) {
        for (WebElement secenek : new Select(gorunurOlunca(ACILIR_LISTE)).getOptions()) {
            if (secenek.getText().equals(gorunenMetin)) {
                return secenek.isEnabled();
            }
        }
        throw new IllegalArgumentException("Böyle bir seçenek yok: " + gorunenMetin);
    }

    private WebElement onayKutusu(int sira) {
        List<WebElement> kutular = surucu.findElements(ONAY_KUTULARI);
        return kutular.get(sira - 1);
    }

    public void onayKutusunaTikla(int sira) {
        onayKutusu(sira).click();
    }

    public boolean onayKutusuIsaretliMi(int sira) {
        return onayKutusu(sira).isSelected();
    }
}
