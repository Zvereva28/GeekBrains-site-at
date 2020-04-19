package ru.geekbrains.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;
    private Page page;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        page = PageFactory.initElements(driver, Page.class);
    }



    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement titlePage;


}
