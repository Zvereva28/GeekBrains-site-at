package ru.geekbrains.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class Page {
    public Page(WebDriver driver) {
        navigation = PageFactory.initElements(driver, Navigation.class);// создаем экземпляр класса Navigation что бы иметь позможноть обращаться к его методам
        header = PageFactory.initElements(driver, Header.class);
        footer = PageFactory.initElements(driver, Footer.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        coursesPage = PageFactory.initElements(driver, CoursesPage.class);
    }

    private final Navigation navigation;
    private final Header header;
    private final Footer footer;
    private final SearchPage searchPage;
    private final LoginPage loginPage;
    private final CoursesPage coursesPage;


    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerPage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    private WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    public Page popUpClosed() {//метод закрытия всплывающего окна
        buttonPopUpClosed.click();
        return this;
    }

    public Page checkNamePage(String exampleNamePage) {// метод проверки заголовка страницы
        String headerPageText = headerPage.getText();
        assertThat(headerPageText, equalToCompressingWhiteSpace(exampleNamePage));
        return this;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public CoursesPage getCoursesPage() {
        return coursesPage;
    }

    public SearchPage startSearch(String wordSearch) {
        buttonSearch.click();
        inputSearch.sendKeys(wordSearch);
        return searchPage;


    }
}

