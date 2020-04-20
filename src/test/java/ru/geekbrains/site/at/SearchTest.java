package ru.geekbrains.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;

@DisplayName("Пороверка поисковой выдачи")
public class SearchTest extends BaseTest {

//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что отобразились блоки и в них:
//    Профессий не менее чем 2
//    Курсов более 15
//    Вебинаров больше чем 180, но меньше 300
//    Блогов более 300
//    Форумов не 350
//    Тестов не 0
//    В Проектах и компаниях отображается GeekBrains

    //Изменить во втором тесте проверки на hamcrest

    @DisplayName("Пороверка выдачи поисковика на слово JAVA")
    @Test
    void SearchJavaTest() {
        driver.get("https://geekbrains.ru/career");

        PageFactory.initElements(driver, Page.class).
                startSearch("java").
                checkTitleNumberGreaterThanOrEqualTo("Профессии", 1).
                checkTitleNumberGreaterThanOrEqualTo("Курсы", 15).
                checkTitleNumberGreaterThanOrEqualTo("Вебинары", 180).
                checkTitleNumberGreaterThanOrEqualTo("Блоги", 300).
                checkTitleNumberGreaterThanOrEqualTo("Форумы", 300).
                checkTitleNumberGreaterThanOrEqualTo("Тесты", 1).
                checkCompanyIsPresent("Образовательный портал GeekBrains");


    }
}
