package com.polar.cape.demo.example.Selenium;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class ItemsPage extends AbstractPage {

    private WebElement bookSearch;

    private WebElement bookId;

    private WebElement filter;

    public ItemsPage(WebDriver driver) {
        super(driver);
    }

}