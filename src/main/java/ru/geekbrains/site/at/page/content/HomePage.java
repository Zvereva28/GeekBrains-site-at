package ru.geekbrains.site.at.page.content;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.page.OpenUrl;
import ru.geekbrains.site.at.page.base.ContentBasePage;

public class HomePage extends ContentBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    @Step("Загружаем страницу https://geekbrains.ru/")
    public HomePage openUrl() {
        driver.get("https://geekbrains.ru/");
        return this;
    }
}
