package ru.geekbrains.site.at.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.content.CoursesPage;

public class ContentNavigationCourseBlock extends BasePage{

    //верхнее меню страницы
    @FindBy(css = "[class*='nav nav-tabs'] [id='prof-link']")
    private WebElement buttonProfessions;

    @FindBy(css = "[class*='nav nav-tabs'] [id='free-link']")
    private WebElement buttonFreeIntensive;

    @FindBy(css = "[class*='nav nav-tabs'] [id='cour-link']")
    private WebElement buttonCourses;

    @FindBy(css = "[class*='nav nav-tabs'] [href*='https://forbusiness']")
    private WebElement buttonCompanies;

    public ContentNavigationCourseBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Step("Выбор пункта {nameButton} в верхнем меню")
    public CoursesPage clickButton(String nameButton) {
        switch (nameButton) {
            case "Профессии": {
                buttonProfessions.click();
                break;
            }
            case "Бесплатные интенсивы": {
                buttonFreeIntensive.click();
                break;
            }
            case "Курсы": {
                buttonCourses.click();
                break;
            }
            case "Компаниям": {
                buttonCompanies.click();
                break;
            }
            default: {
                throw new RuntimeException("Не найдена кнопка с именем: " + nameButton);
            }
        }

        return new CoursesPage(driver);
    }
}
