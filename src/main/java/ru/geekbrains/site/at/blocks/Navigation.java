package ru.geekbrains.site.at.blocks;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.page.content.CoursesPage;
import ru.geekbrains.site.at.page.BasePage;

public class Navigation extends BasePage {

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    private WebElement buttonCareer;

    //private final WebDriver driver;

    public Navigation(WebDriver driver) {
        super(driver);
    }


    public BasePage clickButton(NavigationButton nameButton) {
        BasePage basePage = null;
        switch (nameButton) {

            case buttonCourses: {
                buttonCourses.click();
                basePage = new CoursesPage(driver);
                break;
            }
            case buttonEvents: {
                buttonEvents.click();
                break;
            }
            case buttonTopics: {
                buttonTopics.click();
                break;
            }
            case buttonPosts: {
                buttonPosts.click();
                break;
            }
            case buttonTests: {
                buttonTests.click();
                break;
            }
            case buttonCareer: {
                buttonCareer.click();
                break;
            }
            default: {
                throw new NotFoundException("Не найдена кнопка с именем: " + nameButton);
            }
        }

        return PageFactory.initElements(driver, BasePage.class);

    }
    public enum NavigationButton{
        buttonCourses("Курсы"),
        buttonEvents("Вебинары"),
        buttonTopics("Форум"),
        buttonPosts("Давайте посмотрим как выглядят ошибки))"),
        buttonTests("Тесты"),
        buttonCareer("Карьера");

        private String nameButton;

        NavigationButton(String nameButton) {
            this.nameButton = nameButton;
        }

        public String getText() {
            return nameButton;
        }


    }


}

