package ru.geekbrains.site.at.blocks;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.content.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class Header  extends BasePage {

    //---------------------общие поля----------------------
    @FindBy(css = "[class='gb-header__title']")
    protected WebElement headerTitlePage;

    @FindBy(css = "[id='top-menu'] [class='show-search-form'] svg")
    protected WebElement buttonSearchHeader;

    @FindBy(css = "input[class='search-panel__search-field']")
    protected WebElement inputSearchHeader;
    //-----------------------------------------------

    //-----------------------Поля ТОЛЬКО для НЕ авторизованного-----------------
    @FindBy(css = "[href='/login']")
    private WebElement singInHeader;

    @FindBy(css = "href='/register'")
    private WebElement registrationHeader;
    //--------------------------------------------------------

    //-----------------------Поля только для АВТОРИЗОВАННОГО-----------------------
    @FindBy(css = "header [class='schedule-opener js-schedule-opener']")
    private WebElement buttonCalendarHeader;

    @FindBy(css = "[class='js-notices-link']")
    private WebElement buttonNotifyHeader;

    @FindBy(css = "header [href='/thanks']")
    private WebElement buttonLikeHeader;

    @FindBy(css = "[id='menu-messages']")
    private WebElement buttonMessagesHeader;

    @FindBy(css = "[class='gb-top-menu__item dropdown']")
    private WebElement buttonAvatarHeader;
    //--------------------------------------------------------------

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка корректности Header для зарегестрированного пользователя")
    public BasePage checkHeaderPresentSignUp() {
        System.out.println("Запуск");
        Assertions.assertTrue(headerTitlePage.isDisplayed());
        Assertions.assertTrue(buttonSearchHeader.isDisplayed());
        Assertions.assertTrue(buttonCalendarHeader.isDisplayed());
        Assertions.assertTrue(buttonNotifyHeader.isDisplayed());
        Assertions.assertTrue(buttonLikeHeader.isDisplayed());
        Assertions.assertTrue(buttonMessagesHeader.isDisplayed());
        Assertions.assertTrue(buttonAvatarHeader.isDisplayed());
        return this;// мы не знаем на какой странице проверка звголовка, по этому ставим адаптор этот метод
    }

    @Step("Проверка корректности Header для НЕ зарегестрированного пользователя")
    public BasePage checkHeaderPresentNOTSignUp() {
        System.out.println("Запуск");
        Assertions.assertTrue(headerTitlePage.isDisplayed());
        Assertions.assertTrue(buttonSearchHeader.isDisplayed());
        Assertions.assertTrue(singInHeader.isDisplayed());
        Assertions.assertTrue(registrationHeader.isDisplayed());
        return this;// мы не знаем на какой странице проверка звголовка, по этому ставим адаптор этот метод
    }

    @Step("проверка что имя страницы: {exampleNamePage}")
    public Header checkNamePage(String exampleNamePage) {
        String headerPageText = headerTitlePage.getText();
        assertThat(headerPageText, equalToCompressingWhiteSpace(exampleNamePage));
        return this;// мы не знаем на какой странице проверка звголовка, по этому ставим адаптор этот метод
    }

    @Step("поиск на сайте по тексту: {exampleNamePage}")
    public SearchPage searchText(String text) {
        buttonSearchHeader.click();
        inputSearchHeader.sendKeys(text);
        return new SearchPage(driver);
    }
}
