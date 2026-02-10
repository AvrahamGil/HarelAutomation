package config;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class SeleniumConfig {

    @Bean
    @Primary
    public WebDriver webDriver() {
        WebDriver driver;

        String browser = System.getProperty(Constants.BROWSER_TYPE);
        if(browser == null) System.setProperty(Constants.BROWSER_TYPE, "chrome");

        if(System.getProperty(Constants.BROWSER_TYPE).equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(System.getProperty(Constants.BROWSER_TYPE).equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Cannot open a browser, browser type is illegal");
        }
        return driver;
    }
}
