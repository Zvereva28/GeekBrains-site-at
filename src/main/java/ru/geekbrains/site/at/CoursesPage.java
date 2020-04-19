package ru.geekbrains.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesPage {
    private final WebDriver driver;
    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }
//верхнее меню страницы
    @FindBy(css = "[id=\"prof-link\"]")
    private WebElement topMenuProfButton;

    @FindBy(css = "[id=\"free-link\"]")
    private WebElement topMenuFreeLinkButton;

    @FindBy(css = "[id=\"cour-link\"]")
    private WebElement topMenuCourLinkButton;
}
