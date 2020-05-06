package ru.geekbrains.site.at.page.content;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.site.at.blocks.ContentNavigationCourseBlock;
import ru.geekbrains.site.at.page.BasePage;
import ru.geekbrains.site.at.page.OpenUrl;
import ru.geekbrains.site.at.page.base.ContentBasePage;

import java.util.List;

public class CoursesPage extends ContentBasePage{
    private ContentNavigationCourseBlock contentNavigationCourseBlock;


    @FindBy(xpath = "//a/div/div/span")
    private List<WebElement> courseList;//все курсы на странице
    // чекБокс
    @FindBy(css = "[id=\"filter-0\"]")
    private WebElement checkBoxFree;//Бесплатные

    @FindBy(css = "[id=\"filter-1\"]")
    private WebElement checkBoxForStart;//Для начинающих

    @FindBy(css = "[id=\"filter-2\"]")
    private WebElement checkBoxWebDevel;//Веб-разработка

    @FindBy(css = "[id=\"filter-3\"]")
    private WebElement checkBoxProgramDevel;//Разработка программ

    @FindBy(css = "[id=\"filter-4\"]")
    private WebElement checkBoxWebDesign;//Веб-дизайн

    @FindBy(css = "[id=\"filter-5\"]")
    private WebElement checkBoxMobileDevel;//Мобильная разработка

    @FindBy(css = "[id=\"filter-6\"]")
    private WebElement checkBoxGameDevel;//Разработка игр

    @FindBy(css = "[id=\"filter-7\"]")
    private WebElement checkBoxInformationSecurity;//Информационная безопасность

    @FindBy(css = "[id=\"filter-8\"]")
    private WebElement checkBoxDataScience;//Data Science

    @FindBy(css = "[id=\"filter-9\"]")
    private WebElement checkBoxTesting;//Тестирование

    @FindBy(css = "[id=\"filter-10\"]")
    private WebElement checkBoxInternetMarketing;//Интернет маркетинг

    @FindBy(css = "[id=\"filter-11\"]")
    private WebElement checkBoxSystemAdministration;//Системное администрирование

    @FindBy(css = "[id=\"filter-12\"]")
    private WebElement checkBoxGeekClub;//GeekClub

    @FindBy(css = "[id=\"filter-13\"]")
    private WebElement checkBoxCyberSport;//Киберспорт


    public CoursesPage(WebDriver driver) {

        super(driver);
        this.contentNavigationCourseBlock = new ContentNavigationCourseBlock(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Выбор пункта {nameButton} в checkBox")
    public CoursesPage checkBox(String nameButton) {
        switch (nameButton) {
            case "Бесплатные": {
                checkBoxFree.click();
                break;
            }
            case "Для начинающих": {
                checkBoxForStart.click();
                break;
            }
            case "Веб-разработка": {
                checkBoxWebDevel.click();
                break;
            }
            case "Разработка программ": {
                checkBoxProgramDevel.click();
                break;
            }
            case "Веб-дизайн": {
                checkBoxWebDesign.click();
                break;
            }
            case "Мобильная разработка": {
                checkBoxMobileDevel.click();
                break;
            }
            case "Разработка игр": {
                checkBoxGameDevel.click();
                break;
            }
            case "Информационная безопасность": {
                checkBoxInformationSecurity.click();
                break;
            }
            case "Data Science": {
                checkBoxDataScience.click();
                break;
            }
            case "Тестирование": {
                checkBoxTesting.click();
                break;
            }
            case "Интернет маркетинг": {
                checkBoxInternetMarketing.click();
                break;
            }
            case "Системное администрирование": {
                checkBoxSystemAdministration.click();
                break;
            }
            case "GeekClub": {
                checkBoxGeekClub.click();
                break;
            }
            case "Киберспорт": {
                checkBoxCyberSport.click();
                break;
            }
        }
        return this;
    }

    @Step("Проверка присутствия на странице текста: {text} ")
    public CoursesPage checkTextIsPresent(String text) {
        WebElement element = driver.findElement(By.partialLinkText(text));
        Assertions.assertNotNull(element.getSize());

        return this;
    }

    @Step("Проверяем, что текст {String... args} отображается")
    public CoursesPage checkingDisplayedCourses(String... args) {
        for (String test : args) {
            WebElement element = findElement(courseList, test);
            wait10second.until(ExpectedConditions.visibilityOf(element));
        }
        return this;
    }
    public ContentNavigationCourseBlock getContentNavigationCourseBlock() {
        return contentNavigationCourseBlock;
    }

    @Override
    @Step("Загружаем страницу https://geekbrains.ru/courses")
    public CoursesPage openUrl() {
        driver.get("https://geekbrains.ru/courses");
        return this;
    }
}
