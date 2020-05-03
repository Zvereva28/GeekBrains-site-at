package ru.geekbrains.site.at.page.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.blocks.Footer;
import ru.geekbrains.site.at.blocks.Header;
import ru.geekbrains.site.at.blocks.Navigation;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.OpenUrl;
import ru.geekbrains.site.at.page.content.CoursesPage;
import ru.geekbrains.site.at.page.content.SearchPage;
import ru.geekbrains.site.at.page.sign.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public abstract class ContentBasePage extends BasePage implements OpenUrl {
    protected Navigation navigation;
    protected Header header;
    protected Footer footer;


    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;

    public ContentBasePage(WebDriver driver) {
        super(driver);
        navigation = PageFactory.initElements(driver, Navigation.class);// создаем экземпляр класса Navigation что бы иметь позможноть обращаться к его методам
        header = PageFactory.initElements(driver, Header.class);
        footer = PageFactory.initElements(driver, Footer.class);
        PageFactory.initElements(driver, this);
    }
    @Step("Закрываем всплывающее окно")
    public ContentBasePage popUpClosed() {//метод закрытия всплывающего окна
        buttonPopUpClosed.click();
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

    /**
     * Адаптеры над объектом HeaderBlock
     * После работы с методами HeaderBlock#checkNamePage(String)
     * checkHeaderPresentNOTSignUp()
     * checkHeaderPresentSignUp()
     * сайт остается на тойже странице
     */
    public ContentBasePage checkNamePage(String exampleNamePage) {
        header.checkNamePage(exampleNamePage);
        return this;
    }

    public ContentBasePage checkHeaderPresentNOTSignUp() {
        header.checkHeaderPresentNOTSignUp();
        return this;
    }

    public ContentBasePage checkHeaderPresentSignUp() {
        header.checkHeaderPresentSignUp();
        return this;
    }

    }


