package ru.geekbrains.site.at.page.content;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.geekbrains.site.at.page.OpenUrl;
import ru.geekbrains.site.at.page.base.ContentBasePage;

public class TestPage extends ContentBasePage {


    public TestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Загружаем страницу https://geekbrains.ru/tests")
    public TestPage openUrl() {
        driver.get("https://geekbrains.ru/tests");
        return this;
    }
}
