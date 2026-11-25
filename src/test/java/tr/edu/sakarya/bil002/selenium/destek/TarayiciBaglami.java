package tr.edu.sakarya.bil002.selenium.destek;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Bir senaryonun tarayıcısı. PicoContainer her senaryo için YENİ bir nesne oluşturur ve
 * adım sınıflarına constructor ile verir; böylece adımlar aynı tarayıcıyı paylaşır,
 * senaryolar birbirini etkilemez (her senaryo temiz bir tarayıcıyla başlar).
 */
public class TarayiciBaglami {

    public static final String TEMEL_ADRES = "https://the-internet.herokuapp.com";

    private WebDriver surucu;

    /** Sürücü ilk istendiğinde açılır (tembel başlatma). Kapatma işi Kancalar sınıfında. */
    public WebDriver surucu() {
        if (surucu == null) {
            surucu = yeniSurucu();
        }
        return surucu;
    }

    public boolean acikMi() {
        return surucu != null;
    }

    public void kapat() {
        if (surucu != null) {
            surucu.quit();
            surucu = null;
        }
    }

    private static WebDriver yeniSurucu() {
        ChromeOptions ayarlar = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            ayarlar.addArguments("--headless=new");                 // CI için ekransız çalışma
        }
        ayarlar.addArguments("--window-size=1366,900", "--disable-gpu", "--no-sandbox", "--lang=tr-TR");
        WebDriver surucu = new ChromeDriver(ayarlar);               // Selenium Manager chromedriver'ı bulur/indirir
        surucu.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // Bilerek implicit wait YOK: bütün beklemeler explicit (WebDriverWait) yapılır, ikisini karıştırmak kararsızlık yaratır.
        return surucu;
    }
}
