package tr.edu.sakarya.bil002.selenium.destek;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Cucumber kancaları (hooks). @After her senaryodan sonra çalışır:
 * senaryo başarısızsa ekran görüntüsü alır (HTML rapora eklenir + target/ekran-goruntuleri/ altına yazılır),
 * sonra tarayıcıyı kapatır. Böylece kırmızı bir senaryoda "o an ekranda ne vardı" görülebilir.
 */
public class Kancalar {

    private final TarayiciBaglami baglam;

    public Kancalar(TarayiciBaglami baglam) {
        this.baglam = baglam;
    }

    @After
    public void senaryoSonu(Scenario senaryo) throws IOException {
        try {
            if (senaryo.isFailed() && baglam.acikMi()) {
                byte[] goruntu = ((TakesScreenshot) baglam.surucu()).getScreenshotAs(OutputType.BYTES);
                senaryo.attach(goruntu, "image/png", "Hata anındaki ekran");
                Path klasor = Path.of("target", "ekran-goruntuleri");
                Files.createDirectories(klasor);
                String ad = senaryo.getName().replaceAll("[^A-Za-z0-9]+", "_");
                Files.write(klasor.resolve(ad + ".png"), goruntu);
            }
        } finally {
            baglam.kapat();
        }
    }
}
