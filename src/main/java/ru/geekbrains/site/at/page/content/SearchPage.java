package ru.geekbrains.site.at.page.content;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //ЗАГОЛОВКИ ПОИСКОВОЙ ВЫДАЧИ
    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[2]/a")
    private WebElement titleProfessions;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[3]/a")
    private WebElement titleCourses;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[4]/a")
    private WebElement titleWebinars;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[5]/a")
    private WebElement titleBlog;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[6]/a")
    private WebElement titleForum;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[7]/a")
    private WebElement titleTests;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[8]/a")
    private WebElement titleCompanies;

    @FindBy(linkText = "Образовательный портал GeekBrains")
    private WebElement blockCompanies;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    private WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    //ДЛЯ SEARCH TEST
    @Step("Проверка поисковой выдачи элементов раздела {nameTitle} не менее {Integer minNumber}")
    public SearchPage checkTitleNumberGreaterThanOrEqualTo(String nameTitle, Integer minNumber) {
        switch (nameTitle) {
            case "Профессии": {
                String[] token = titleProfessions.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case "Курсы": {
                String[] token = titleCourses.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case "Вебинары": {
                String[] token = titleWebinars.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case "Блоги": {
                String[] token = titleBlog.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case "Форумы": {
                String[] token = titleForum.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case "Тесты": {
                String[] token = titleTests.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case "Компании": {
                String[] token = titleCompanies.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }

            default: {
                throw new NotFoundException("Не найден заголовок с именем: " + nameTitle);
            }

        }
        return this;
    }

    @Step("Проверка присутствия на странице текста: {nameCompany} ")
    public SearchPage checkCompanyIsPresent(String nameCompany) {
        WebElement element = driver.findElement(By.partialLinkText(nameCompany));
        Assertions.assertNotNull(element.getSize());

        return this;
    }
}
