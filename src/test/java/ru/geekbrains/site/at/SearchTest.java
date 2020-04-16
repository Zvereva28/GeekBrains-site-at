package ru.geekbrains.site.at;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.site.at.base.BaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

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
        careerPage.startPageCareer();
        careerPage.startSearch("java");

        assertThat(searchPage.numberElementsTitleSearch(SearchPage.TITLE_PROFESSIONS_BUTTON_SELECTOR), greaterThanOrEqualTo(2));
        assertThat(searchPage.numberElementsTitleSearch(SearchPage.TITLE_COURSES_BUTTON_SELECTOR), greaterThan(15));
        assertThat(searchPage.numberElementsTitleSearch(SearchPage.TITLE_WEBINARS_BUTTON_SELECTOR), allOf(
                greaterThan(180),
                lessThan(300)));
        assertThat(searchPage.numberElementsTitleSearch(SearchPage.TITLE_BLOG_BUTTON_SELECTOR) , greaterThanOrEqualTo(300));
        assertThat(searchPage.numberElementsTitleSearch(SearchPage.TITLE_WEBINARS_BUTTON_SELECTOR), anyOf(
                greaterThan(350),
                lessThan(350)));//вот такая странная проверка на неравенство
        assertThat(searchPage.numberElementsTitleSearch(SearchPage.TITLE_TESTS_BUTTON_SELECTOR), greaterThan(0));

//        Assertions.assertTrue(searchPage.numberElementsTitleSearch(SearchPage.TITLE_PROFESSIONS_BUTTON_SELECTOR) >= 2);
//        Assertions.assertTrue(searchPage.numberElementsTitleSearch(SearchPage.TITLE_COURSES_BUTTON_SELECTOR) > 15);
//        Assertions.assertTrue(searchPage.numberElementsTitleSearch(SearchPage.TITLE_WEBINARS_BUTTON_SELECTOR) > 180 &
//                                        searchPage.numberElementsTitleSearch(SearchPage.TITLE_WEBINARS_BUTTON_SELECTOR) < 300 );
//        Assertions.assertTrue(searchPage.numberElementsTitleSearch(SearchPage.TITLE_BLOG_BUTTON_SELECTOR) >= 300);
//        Assertions.assertTrue(searchPage.numberElementsTitleSearch(SearchPage.TITLE_FORUM_BUTTON_SELECTOR) != 350);
//        Assertions.assertTrue(searchPage.numberElementsTitleSearch(SearchPage.TITLE_TESTS_BUTTON_SELECTOR) != 0);


    }
}
