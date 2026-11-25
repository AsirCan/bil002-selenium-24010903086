package tr.edu.sakarya.bil002.selenium.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Bütün sayfa sınıflarının ortak atası. Elemanlar sadece explicit wait (WebDriverWait +
 * ExpectedConditions) ile bulunur: eleman hazır olana kadar en fazla 10 sn beklenir, hazır olunca
 * hemen devam edilir. Thread.sleep kullanılmaz (sabit bekleme hem yavaş hem kararsızdır).
 */
public abstract class TemelSayfa {

    protected final WebDriver surucu;
    protected final WebDriverWait bekle;

    protected TemelSayfa(WebDriver surucu) {
        this.surucu = surucu;
        this.bekle = new WebDriverWait(surucu, Duration.ofSeconds(10));
    }

    protected WebElement gorunurOlunca(By konum) {
        return bekle.until(ExpectedConditions.visibilityOfElementLocated(konum));
    }

    protected WebElement tiklanabilirOlunca(By konum) {
        return bekle.until(ExpectedConditions.elementToBeClickable(konum));
    }

    protected void yaz(By konum, String metin) {
        WebElement alan = gorunurOlunca(konum);
        alan.clear();
        alan.sendKeys(metin);
    }

    public String baslik() {
        return surucu.getTitle();
    }

    public String adres() {
        return surucu.getCurrentUrl();
    }
}
