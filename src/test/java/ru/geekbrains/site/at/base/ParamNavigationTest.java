package ru.geekbrains.site.at.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import ru.geekbrains.site.at.Header;
import java.util.stream.Stream;

@DisplayName("Проверка навигации(параметризованная)")
public class ParamNavigationTest extends BaseTest{
    @ParameterizedTest
    @MethodSource("stringAndByProvider")
    void PNTests(By by, String title){
        careerPage.startPageCareer();
        careerPage.clickButton(by);
        Assertions.assertEquals(title,coursesPage.getHeaderTitle());
    }
    static Stream<Arguments> stringAndByProvider() {
        return Stream.of(Arguments.of(Header.COURSES_BUTTON_SELECTOR, "Курсы"), Arguments.of(Header.EVENTS_BUTTON_SELECTOR, "Вебинары"), Arguments.of(Header.TOPICS_BUTTON_SELECTOR, "Форум"));
    }

}
