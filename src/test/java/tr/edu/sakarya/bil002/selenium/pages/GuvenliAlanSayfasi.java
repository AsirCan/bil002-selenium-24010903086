package tr.edu.sakarya.bil002.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/** Page Object: girişten sonra açılan /secure sayfası. */
public class GuvenliAlanSayfasi extends TemelSayfa {

    private static final By BASLIK = By.cssSelector("div.example h2");
    private static final By BILDIRIM = By.id("flash");
    private static final By CIKIS = By.cssSelector("a[href='/logout']");

    public GuvenliAlanSayfasi(WebDriver surucu) {
        super(surucu);
    }

    /** Sayfanın gerçekten yüklendiğini bekler (adres /secure olana kadar). */
    public GuvenliAlanSayfasi yuklendi() {
        bekle.until(ExpectedConditions.urlContains("/secure"));
        gorunurOlunca(BASLIK);
        return this;
    }

    public String baslikMetni() {
        return gorunurOlunca(BASLIK).getText();
    }

    public String bildirim() {
        return gorunurOlunca(BILDIRIM).getText().replace("×", "").trim();
    }

    public void cikisYap() {
        tiklanabilirOlunca(CIKIS).click();
    }
}
