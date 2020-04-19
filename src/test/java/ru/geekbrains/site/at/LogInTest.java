package ru.geekbrains.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;
@DisplayName("Регистрация корректные данные")
public class LogInTest extends BaseTest {

    @Test
    void LogIn1Test() {
        driver.get("https://geekbrains.ru/login");

        PageFactory.initElements(driver, Page.class).
                getLoginPage().
                LogIN("hao17583@bcaoo.com", "hao17583");
        PageFactory.initElements(driver, Page.class).checkNamePage("Главная");

    }
    @Test
    void Check1AfterLogIn1Test() {
        driver.get("https://geekbrains.ru/login");

        PageFactory.initElements(driver, Page.class).
                getLoginPage().
                LogIN("hao17583@bcaoo.com", "hao17583");
        PageFactory.initElements(driver, Page.class).
                checkNamePage("Главная").
                getNavigation().
                clickButton("Курсы");

    }
}
