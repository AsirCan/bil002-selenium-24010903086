package tr.edu.sakarya.bil002.selenium.runner;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Koşucu: src/test/resources/features altındaki .feature dosyalarını JUnit 5 Platform üzerinde çalıştırır.
 * glue = adım tanımlarının ve kancaların (hooks) bulunduğu paket.
 * Rapor: target/cucumber-rapor.html (başarısız senaryolarda ekran görüntüsü ekli).
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "tr.edu.sakarya.bil002.selenium")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-rapor.html")
public class CucumberTestRunner {
}
