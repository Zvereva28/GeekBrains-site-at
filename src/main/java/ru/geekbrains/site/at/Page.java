package ru.geekbrains.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

public class Page {
    public Page(WebDriver driver) {
        navigation = PageFactory.initElements(driver, Navigation.class);// создаем экземпляр класса Navigation что бы иметь позможноть обращаться к его методам
//        header = PageFactory.initElements(driver, Header.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        //mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
    }

    private Navigation navigation;
    private Header header;
    private SearchPage searchPage;
    private MainPage mainPage;
    private LoginPage loginPage;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerPage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    private WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;


//.search-page-block__content .company-items

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
    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SearchPage startSearch(String wordSearch) {
        buttonSearch.click();
        inputSearch.sendKeys(wordSearch);
        return searchPage;


    }
}



//    public static final By TITLE_PROFESSIONS_BUTTON_SELECTOR = By.xpath();//
//    public static final By TITLE_COURSES_BUTTON_SELECTOR = By.xpath();//
//    public static final By TITLE_WEBINARS_BUTTON_SELECTOR = By.xpath();//
//    public static final By TITLE_BLOG_BUTTON_SELECTOR = By.xpath();//
//    public static final By TITLE_FORUM_BUTTON_SELECTOR = By.xpath();//
//    public static final By TITLE_TESTS_BUTTON_SELECTOR = By.xpath();//
//    public static final By TITLE_COMPANIES_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[8]/a");//Компании
