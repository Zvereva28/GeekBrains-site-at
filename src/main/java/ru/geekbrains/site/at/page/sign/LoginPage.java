package ru.geekbrains.site.at.page.sign;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.OpenUrl;
import ru.geekbrains.site.at.page.base.ContentBasePage;
import ru.geekbrains.site.at.page.content.HomePage;

public class LoginPage extends BasePage implements OpenUrl {

    @FindBy(css = "[id=\"user_email\"]")
    private WebElement inputEmail;

    @FindBy(css = "[id=\"user_password\"]")
    private WebElement inputPassword;

    @FindBy(css = "[class=\"btn btn-block btn-success\"]")
    private WebElement buttonEnter;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Авторизация почта: {email} пароль: {password}")
    public HomePage logIN(String email, String password) {
        inputEmail.click();
        inputEmail.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonEnter.click();
        return new HomePage(driver);
    }

    @Override
    @Step("Загружаем страницу https://geekbrains.ru/login")
    public LoginPage openUrl() {
        driver.get("https://geekbrains.ru/login");
        return this;
    }
}
