package com.polar.cape.demo.example.Selenium;

import com.polar.cape.demo.Model.Author;
import com.polar.cape.demo.Model.Enumeration.BookType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddOrEditBook extends AbstractPage {

    private WebElement title;
    private WebElement ISBN;
    private WebElement yearCreated;
    private WebElement author;
    private WebElement bookType;

    public AddOrEditBook(WebDriver driver) {
        super(driver);
    }

    public static ItemsPage add(WebDriver driver, String addPath, String title, String ISBN, int yearCreated, Author author, BookType bookType) {
        get(driver, addPath);
        AbstractPage.assertRelativeUrl(driver, addPath);
        AddOrEditBook addOrEditBook = PageFactory.initElements(driver, AddOrEditBook.class);
        addOrEditBook.title.sendKeys(title);
        addOrEditBook.ISBN.sendKeys(ISBN);

        return PageFactory.initElements(driver, ItemsPage.class);
    }

}
