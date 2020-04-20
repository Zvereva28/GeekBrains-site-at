package ru.geekbrains.site.at;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private final WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    private WebElement buttonSearchHeader;

    public Page CheckHeaderPresent() {
        System.out.println("Запуск");
        Assertions.assertNotNull(buttonSearchHeader.getSize());
        return PageFactory.initElements(driver, Page.class);
    }
}
