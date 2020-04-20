package ru.geekbrains.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;

import java.util.stream.Stream;


//        Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера
@DisplayName("Проверка навигации")
public class NavigationTest extends BaseTest {

    static Stream<String> stringProvider() {
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @DisplayName("Нажатие в навигации")
    @ParameterizedTest(name = "{index} => переход на страницу {0}")
    @MethodSource("stringProvider")
    void checkNavigation(String namePage) {
        driver.get("https://geekbrains.ru/career");

        PageFactory.initElements(driver, Page.class)
                .getNavigation().clickButton(namePage)
                .checkNamePage(namePage).
                getHeader().
                CheckHeaderPresent().
                getFooter().
                CheckFooterPresent();
    }

}