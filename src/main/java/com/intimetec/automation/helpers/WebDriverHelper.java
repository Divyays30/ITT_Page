// Ensure this corresponds to the actual directory structure of the file,
// or move the file to the correct folder path.
package com.intimetec.automation.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WebDriverHelper {
    // Declare WebDriver as static
    private static WebDriver driver;

    // Method to initialize the WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/Users/gopi/Downloads/chromedriver-mac-arm64/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }
        return driver;
    }

    // Quit the WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}