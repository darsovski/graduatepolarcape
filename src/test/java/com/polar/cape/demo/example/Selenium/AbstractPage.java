package com.polar.cape.demo.example.Selenium;


import com.polar.cape.demo.util.ExamAssert;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void get(WebDriver driver, String relativeUrl) {
        String url = System.getProperty("geb.build.baseUrl", "http://localhost:9999") + relativeUrl;
        driver.get(url);
    }

    public static void assertRelativeUrl(WebDriver driver, String relativeUrl) {
        String url = System.getProperty("geb.build.baseUrl", "http://localhost:9999") + relativeUrl;
        String current = driver.getCurrentUrl();
        ExamAssert.assertEquals("Current url is not " + relativeUrl, url, current);
    }

    public static void assertAbsoluteUrl(WebDriver driver, String url) {

        String current = driver.getCurrentUrl();
        ExamAssert.assertEquals("Current url is not " + url, url, current);
    }

}
