package com.intimetec.automation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.intimetec.automation.helpers.ExtentReportManagerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.intimetec.automation.helpers.ExtentReportManagerUtils.createExtentReports;

public class CareersPage {
    private WebDriver driver;

    // Locators
    private By indiaCareersLink = By.xpath("//a[@class='btn itt-btn-pghost large']"); // Locator for 'India Careers'
    private By languageSelector = By.xpath("(//div[@class='globe_class'])[2]");
    private By australiaEnglishLanguage = By.xpath("//a[text()='Australia (English)']");
    private By koreaEnglishLanguage = By.xpath("//a[text()='Korea (Korean)']");

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnIndiaCareers() {
        ExtentReports extentReports = ExtentReportManagerUtils.createExtentReports(); // Ensuring ExtentReports is properly initialized.
        ExtentTest test = extentReports.createTest("Click on India Careers");
        try {
            WebElement element = driver.findElement(indiaCareersLink);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            test.info("Scrolled to 'India Careers' link.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            test.info("Clicked on 'India Careers' link using JavaScript.");

            // Switch to new tab
            ArrayList<String> allTabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(allTabs.get(1));
            test.info("Switched to new tab: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().equals("https://careers.intimetec.in/intimetec/")) {
                test.pass("Successfully navigated to the correct 'India Careers' page.");
            } else {
                test.fail("Navigation to 'India Careers' page failed. Current URL: " + driver.getCurrentUrl());
            }

            String currentTab = driver.getWindowHandle(); // Store the current tab handle
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            for (String tab : tabs) {
                if (!tab.equals(currentTab)) {
                    driver.switchTo().window(tab); // Switch to the previous tab
                    test.info("Switched to the previous tab.");
                    break;
                }
            }
            driver.switchTo().window(currentTab); // Switch back to the parent tab
            driver.close(); // Close the child tab
            driver.switchTo().window(tabs.get(0)); // Switch to parent window
            test.info("Closed child tab and switched back to the parent tab.");
        } catch (Exception e) {
            test.fail("An error occurred while navigating to 'India Careers': " + e.getMessage());
        }
    }

    public void clickOnAusLanguageSelector() {
        ExtentReports extentReports = ExtentReportManagerUtils.createExtentReports(); // Ensuring ExtentReports is properly initialized.
        ExtentTest test = extentReports.createTest("Click on Australia (English) Language Selector");
        try {
            WebElement languageElement = driver.findElement(languageSelector);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", languageElement);
            test.info("Scrolled to language selector.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", languageElement);
            test.info("Clicked on language selector.");

            // Select Australia (English)
            WebElement australiaEnglishOption = driver.findElement(australiaEnglishLanguage);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", australiaEnglishOption);
            test.info("Scrolled to 'Australia (English)' option.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", australiaEnglishOption);
            test.pass("Successfully selected 'Australia (English)' option.");
        } catch (Exception e) {
            test.fail("An error occurred while selecting 'Australia (English)': " + e.getMessage());
        }
    }

    public void clickOnKoreaEnglishLanguage() {
        ExtentReports extentReports = ExtentReportManagerUtils.createExtentReports(); // Ensuring ExtentReports is properly initialized.
        ExtentTest test = extentReports.createTest("Click on Korea (Korean) Language Selector");
        try {
            WebElement languageElement = driver.findElement(languageSelector);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", languageElement);
            test.info("Scrolled to language selector.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", languageElement);
            test.info("Clicked on language selector.");

            // Select Korea (Korean)
            WebElement koreaEnglishOption = driver.findElement(koreaEnglishLanguage);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", koreaEnglishOption);
            test.info("Scrolled to 'Korea (Korean)' option.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", koreaEnglishOption);
            test.pass("Successfully selected 'Korea (Korean)' option.");
        } catch (Exception e) {
            test.fail("An error occurred while selecting 'Korea (Korean)': " + e.getMessage());
        }
    }
}