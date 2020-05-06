package ru.geekbrains.site.at.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.page.base.ContentBasePage;
import ru.geekbrains.site.at.page.content.CoursesPage;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.content.HomePage;
import ru.geekbrains.site.at.page.content.TestPage;
import ru.geekbrains.site.at.utill.PageNotCreateException;

public class Navigation extends BasePage {

    @FindBy(css = "[class='svg-icon icon-logo']")
    private WebElement icon;

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


    public Navigation(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Step("Нажатие кнопки {button}")
    public ContentBasePage clickButton(NavigationButton button) {
        ContentBasePage contentBasePage = null;

        switch (button) {
            case icon:
                icon.click();
                contentBasePage = new HomePage(driver);
                break;
            case buttonCourses:
                buttonCourses.click();
                contentBasePage = new CoursesPage(driver);
                break;
            case buttonEvents:
                buttonEvents.click();
                contentBasePage = new HomePage(driver);
                break;
            case buttonTopics:
                buttonTopics.click();
                contentBasePage = new HomePage(driver);
                break;
            case buttonPosts:
                buttonPosts.click();
                contentBasePage = new HomePage(driver);
                break;
            case buttonTests:
                buttonTests.click();
                contentBasePage = new TestPage(driver);
                break;
            case buttonCareer:
                buttonCareer.click();
                contentBasePage = new HomePage(driver);
                break;
        }
        if(null==contentBasePage){
            throw new PageNotCreateException("Страница: "+button.getText()+" не описана!");
        }

        return contentBasePage;
    }


    public enum NavigationButton{
        icon("Главная"),
        buttonCourses("Курсы"),
        buttonEvents("Вебинары"),
        buttonTopics("Форум"),
        buttonPosts("Блог"),
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

