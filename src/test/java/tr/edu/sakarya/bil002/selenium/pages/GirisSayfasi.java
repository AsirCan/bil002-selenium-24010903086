package tr.edu.sakarya.bil002.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tr.edu.sakarya.bil002.selenium.destek.TarayiciBaglami;

/**
 * Page Object: /login sayfası. Bu sayfanın bütün locator'ları SADECE burada.
 * Sitede bir id değişirse tek değişecek yer bu sınıftır; adım tanımları etkilenmez.
 * Locator seçimi: id (en kararlı) > name > CSS > XPath (en kırılgan).
 */
public class GirisSayfasi extends TemelSayfa {

    private static final By KULLANICI_ADI = By.id("username");
    private static final By SIFRE = By.id("password");
    private static final By GIRIS_BUTONU = By.cssSelector("button[type='submit']");
    private static final By BILDIRIM = By.id("flash");
    private static final By BASLIK = By.tagName("h2");

    public GirisSayfasi(WebDriver surucu) {
        super(surucu);
    }

    public GirisSayfasi ac() {
        surucu.get(TarayiciBaglami.TEMEL_ADRES + "/login");
        gorunurOlunca(KULLANICI_ADI);
        return this;
    }

    /** Bilgileri girip "Login"e basar. Başarılı mı başarısız mı, adım tanımı doğrular. */
    public void girisYap(String kullanici, String sifre) {
        yaz(KULLANICI_ADI, kullanici);
        yaz(SIFRE, sifre);
        tiklanabilirOlunca(GIRIS_BUTONU).click();
    }

    /** Sayfanın üstündeki bildirim (yeşil başarı ya da kırmızı hata kutusu) metni. */
    public String bildirim() {
        return gorunurOlunca(BILDIRIM).getText().replace("×", "").trim();
    }

    public boolean hataBildirimiMi() {
        return gorunurOlunca(BILDIRIM).getAttribute("class").contains("error");
    }

    public String sayfaBasligi() {
        return gorunurOlunca(BASLIK).getText();
    }
}
