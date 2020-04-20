package ru.geekbrains.site.at;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {
    private final WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(css = "[class=\"site-footer__phone\"]")
    private WebElement buttonPhoneFooter;

    @FindBy(css = "[class=\"site-footer__copyright\"]")
    private WebElement buttonCopyrightFooter;

    @FindBy(css = "[href=\"/feedbacks\"]")
    private WebElement buttonFeedbackFooter;

    @FindBy(css = "[href=\"/company\"]")
    private WebElement buttonAboutProjectFooter;

    @FindBy(css = "[href=\"/license.pdf\"]")
    private WebElement buttonLicenseFooter;


    public Page CheckFooterPresent() {
        System.out.println("Запуск");
        Assertions.assertNotNull(buttonPhoneFooter.getSize());
        Assertions.assertNotNull(buttonCopyrightFooter.getSize());
        Assertions.assertNotNull(buttonFeedbackFooter.getSize());
        Assertions.assertNotNull(buttonAboutProjectFooter.getSize());
        Assertions.assertNotNull(buttonLicenseFooter.getSize());
        return PageFactory.initElements(driver, Page.class);
    }
}
