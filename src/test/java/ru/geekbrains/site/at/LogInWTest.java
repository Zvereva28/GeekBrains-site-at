package ru.geekbrains.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;
import ru.geekbrains.site.at.blocks.Navigation;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.sign.LoginPage;

import static java.lang.Thread.sleep;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Регистрация корректные данные")
public class LogInWTest extends BaseTest {
    @DisplayName("Только регистрация")
    @Description(value = "1. Перейти на страницу авторизация https://geekbrains.ru/login\n" +
            "2. Ввести логин : hao17583@bcaoo.com\n" +
            "3. Пароль: hao17583\n" +
            "4. Нажать кнопку войти\n" +
            "5. Проверить что отобразилась страница \"Главная\"\n")
    @Test
    void LogIn1Test() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";
        new LoginPage(driver).openUrl().logIN(login, password).checkNamePage("Главная");


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
    void Check1AfterLogIn1Test() throws InterruptedException {

        String login = "hao17583@bcaoo.com";
        String password = "hao17583";
        new LoginPage(driver).
                openUrl().
                logIN(login, password).
                checkNamePage("Главная").
                getNavigation().
                clickButton(Navigation.NavigationButton.buttonCourses).
                getNavigation().
                clickButton(Navigation.NavigationButton.buttonCourses).
                getContentNavigationCourseBlock().
                clickButton("Курсы").
                checkBox("Бесплатные").
                checkBox("Тестирование").
                checkingDisplayedCourses( "Тестирование ПО. Уровень 1",
                "Тестирование ПО. Уровень 2");
        sleep(5000);


    }
}
