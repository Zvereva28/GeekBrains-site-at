package ru.geekbrains.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerPage extends Header{
    private static final String CAREER_PAGE_URL = "https://geekbrains.ru/career";


    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public void startPageCareer(){//метод выхода на страницу
        driver.get(CAREER_PAGE_URL);
    }

    public void startSearch(String wordSearch){
        WebElement buttonSearch = driver.findElement(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys(wordSearch);
        WebDriverWait wait = new WebDriverWait(driver, 40);
    }
}

