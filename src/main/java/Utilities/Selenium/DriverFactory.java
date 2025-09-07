package Utilities.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;

public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            // set brave browser path manually
            ChromeOptions options = new ChromeOptions();
            options.setBinary(Paths.get("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe").toString());

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        }
        return driver;
    }
}
