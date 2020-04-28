package ru.geekbrains.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Регистрация корректные данные")
public class LogInTest extends BaseTest {
    @DisplayName("Только регистрация")
    @Description(value = "1. Перейти на страницу авторизация https://geekbrains.ru/login\n" +
            "2. Ввести логин : hao17583@bcaoo.com\n" +
            "3. Пароль: hao17583\n" +
            "4. Нажать кнопку войти\n" +
            "5. Проверить что отобразилась страница \"Главная\"\n")
    @Test
    void LogIn1Test() {
        driver.get("https://geekbrains.ru/login");

        PageFactory.initElements(driver, Page.class).
                getLoginPage().
                logIN("hao17583@bcaoo.com", "hao17583");
        PageFactory.initElements(driver, Page.class).checkNamePage("Главная");

    }

    @Description(value = "1. Перейти на страницу авторизация https://geekbrains.ru/login\n" +
            "2. Ввести логин : hao17583@bcaoo.com\n" +
            "3. Пароль: hao17583\n" +
            "4. Нажать кнопку войти\n" +
            "5. Проверить что отобразилась страница \"Главная\"\n" +
            "6. Нажать в навигации \"Курсы\"\n" +
            "7. Нажать в шапке сайта \"Курсы\"\n" +
            "8. Выбрать в фильтрах чекбокс \"Бесплатные\"\n" +
            "9. Выбрать в фильтрах чекбокс \"Тестирование\"")
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
                clickButton(Navigation.NavigationButton.buttonCourses).
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
