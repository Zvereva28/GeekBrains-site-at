package ru.geekbrains.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.base.BaseTest;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.content.SearchPage;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Пороверка поисковой выдачи")
public class SearchWTest extends BaseTest {

    @Description(value = "1. Перейти на сайт https://geekbrains.ru/courses\n" +
            "2. Нажать на кнопку Поиск\n" +
            "3. В поле Поиск ввести текст: java")
    @DisplayName("Пороверка выдачи поисковика на слово JAVA")
    @Test
    void SearchJavaTest() {
        driver.get("https://geekbrains.ru/career");

        new SearchPage(driver).
                openUrl().
                getHeader().
                searchText("java").
                checkTitleNumberGreaterThanOrEqualTo(SearchPage.SearchTitle.tabProfessions, 1).
                checkTitleNumberGreaterThanOrEqualTo(SearchPage.SearchTitle.tabCourses, 15).
                checkTitleNumberGreaterThanOrEqualTo(SearchPage.SearchTitle.tabWebinars, 180).
                checkTitleNumberGreaterThanOrEqualTo(SearchPage.SearchTitle.tabBlog, 300).
                checkTitleNumberGreaterThanOrEqualTo(SearchPage.SearchTitle.tabForum, 300).
                checkTitleNumberGreaterThanOrEqualTo(SearchPage.SearchTitle.tabCompanies, 1).
                checkCompanyIsPresent("Образовательный портал GeekBrains");


    }
}
