package ru.geekbrains.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.site.at.base.BaseTest;
import ru.geekbrains.site.at.blocks.Navigation;
import ru.geekbrains.site.at.page.content.TestPage;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка навигации")
public class NavigationWTest extends BaseTest {

    static Navigation.NavigationButton[] stringProvider() {
        return  Navigation.NavigationButton.values();
    }

    @DisplayName("Нажатие в навигации")
    @ParameterizedTest(name = "{index} => переход на страницу {0}")
    @MethodSource("stringProvider")
    void checkNavigation(Navigation.NavigationButton button) throws InterruptedException {
        new TestPage(driver)
                .openUrl()
                .getNavigation().
                clickButton(button)
                .getHeader().
                checkNamePage(button.getText());
    }

}