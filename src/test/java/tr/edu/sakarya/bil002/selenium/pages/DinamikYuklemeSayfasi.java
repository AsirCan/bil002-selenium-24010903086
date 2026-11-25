package tr.edu.sakarya.bil002.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tr.edu.sakarya.bil002.selenium.destek.TarayiciBaglami;

/**
 * Page Object: /dynamic_loading/1 ve /2. "Start"a basınca birkaç saniye "Loading..." görünür,
 * sonra "Hello World!" çıkar. Örnek 1: eleman sayfada vardır ama gizlidir. Örnek 2: eleman sonradan
 * DOM'a eklenir. Explicit wait'in neden gerektiğini en iyi gösteren sayfa: sabit bir süre beklemek
 * ya yetmez (kararsız test) ya da gereksiz uzun olur.
 */
public class DinamikYuklemeSayfasi extends TemelSayfa {

    private static final By BASLAT = By.cssSelector("#start button");
    private static final By YUKLENIYOR = By.id("loading");
    private static final By SONUC = By.cssSelector("#finish h4");

    public DinamikYuklemeSayfasi(WebDriver surucu) {
        super(surucu);
    }

    public DinamikYuklemeSayfasi ac(int ornekNo) {
        surucu.get(TarayiciBaglami.TEMEL_ADRES + "/dynamic_loading/" + ornekNo);
        gorunurOlunca(BASLAT);
        return this;
    }

    public void baslat() {
        tiklanabilirOlunca(BASLAT).click();
    }

    /** Sonuç görünene kadar bekler (en fazla 10 sn) ve metni döndürür. */
    public String sonucMetni() {
        return gorunurOlunca(SONUC).getText();
    }

    /** Yükleme göstergesinin kaybolduğunu doğrulamak için. */
    public boolean yuklemeBittiMi() {
        return bekle.until(ExpectedConditions.invisibilityOfElementLocated(YUKLENIYOR));
    }

    /** Başlatmadan önce sonuç görünmüyor olmalı (Örnek 1'de gizli, Örnek 2'de hiç yok). */
    public boolean sonucGorunuyorMu() {
        return !surucu.findElements(SONUC).isEmpty() && surucu.findElement(SONUC).isDisplayed();
    }
}
