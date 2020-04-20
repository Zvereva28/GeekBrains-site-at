package ru.geekbrains.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[id=\"user_email\"]")
    private WebElement inputEmail;

    @FindBy(css = "[id=\"user_password\"]")
    private WebElement inputPassword;

    @FindBy(css = "[class=\"btn btn-block btn-success\"]")
    private WebElement buttonEnter;

    public Page logIN(String email, String password) {
        inputEmail.click();
        inputEmail.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonEnter.click();
        return PageFactory.initElements(driver, Page.class);
    }

}
