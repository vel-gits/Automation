package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if ("chrome".equalsIgnoreCase(browser)) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\velmu\\Documents\\VelmuruganR\\Work\\Depedency\\chromedriver-win64\\chromedriver.exe");
               
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");

                // Initialize ChromeDriver with options
                driver = new ChromeDriver(options);
                
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
