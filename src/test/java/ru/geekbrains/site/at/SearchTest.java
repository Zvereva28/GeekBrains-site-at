package ru.geekbrains.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;
import ru.geekbrains.site.at.page.BasePage;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Пороверка поисковой выдачи")
public class SearchTest extends BaseTest {

    @Description(value = "1. Перейти на сайт https://geekbrains.ru/courses\n" +
            "2. Нажать на кнопку Поиск\n" +
            "3. В поле Поиск ввести текст: java")
    @DisplayName("Пороверка выдачи поисковика на слово JAVA")
    @Test
    void SearchJavaTest() {
        driver.get("https://geekbrains.ru/career");

        PageFactory.initElements(driver, BasePage.class).
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
