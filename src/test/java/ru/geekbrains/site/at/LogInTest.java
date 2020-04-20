package ru.geekbrains.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;

@DisplayName("Регистрация корректные данные")
public class LogInTest extends BaseTest {
    @DisplayName("Только регистрация")
    @Test
    void LogIn1Test() {
        driver.get("https://geekbrains.ru/login");

        PageFactory.initElements(driver, Page.class).
                getLoginPage().
                logIN("hao17583@bcaoo.com", "hao17583");
        PageFactory.initElements(driver, Page.class).checkNamePage("Главная");

    }

    @DisplayName("Регистрация плюс проверка")
    @Test
    void Check1AfterLogIn1Test() {
        driver.get("https://geekbrains.ru/login");

        PageFactory.initElements(driver, Page.class).
                getHeader().
                CheckHeaderPresent().
                getFooter().
                CheckFooterPresent().
                getLoginPage().
                logIN("hao17583@bcaoo.com", "hao17583").
                getHeader().
                CheckHeaderPresent().getFooter().CheckFooterPresent().
                checkNamePage("Главная").
                getNavigation().
                clickButton("Курсы").
                getFooter().
                CheckFooterPresent().
                getHeader().
                CheckHeaderPresent().
                getCoursesPage().
                clickButtonTopMenu("Курсы").
                getHeader().
                CheckHeaderPresent().
                getFooter().
                CheckFooterPresent().
                getCoursesPage().
                checkBox("Бесплатные").
                checkBox("Тестирование").
                checkTextIsPresent("Тестирование ПО. Уровень 1").
                checkTextIsPresent("Тестирование ПО. Уровень 2");

    }
}
