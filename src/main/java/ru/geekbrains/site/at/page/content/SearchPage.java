package ru.geekbrains.site.at.page.content;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.site.at.blocks.SearchTabsBlock;
import ru.geekbrains.site.at.page.OpenUrl;
import ru.geekbrains.site.at.page.base.ContentBasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

public class SearchPage extends ContentBasePage {

    private SearchTabsBlock searchTabsBlock;
    public SearchPage(WebDriver driver) {
        super(driver);
        this.searchTabsBlock = new SearchTabsBlock(driver);
    }

    //ЗАГОЛОВКИ ПОИСКОВОЙ ВЫДАЧИ
    @FindBy(css = "[class='search-page-tabs'] [data-tab='all']")
    private WebElement tabEveryWhere;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='professions']")
    private WebElement tabProfessions;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='courses']")
    private WebElement tabCourses;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='webinars']")
    private WebElement tabWebinars;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='blogs']")
    private WebElement tabBlogs;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='forums']")
    private WebElement tabForums;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='tests']")
    private WebElement tabTests;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='companies']")
    private WebElement tabCompanies;



    @FindBy(linkText = "Образовательный портал GeekBrains")
    private WebElement blockCompanies;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    private WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    //ДЛЯ SEARCH TEST
    @Step("Проверка поисковой выдачи элементов раздела {nameTitle} не менее {Integer minNumber}")
    public SearchPage checkTitleNumberGreaterThanOrEqualTo(SearchTitle nameTitle, Integer minNumber) {
        switch (nameTitle) {
            case tabProfessions: {
                String[] token = tabProfessions.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case tabCourses: {
                String[] token = tabCourses.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case tabWebinars: {
                String[] token = tabWebinars.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case tabBlog: {
                String[] token = tabBlogs.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case tabForum: {
                String[] token = tabForums.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case tabTests: {
                String[] token = tabTests.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(minNumber));
                break;
            }
            case tabCompanies: {
                String[] token = tabCompanies.getText().split("・");
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
    public enum SearchTitle{
        tabProfessions("Профессии"),
        tabCourses("Курсы"),
        tabWebinars("Вебинары"),
        tabBlog("Блоги"),
        tabForum("Форумы"),
        tabTests("Тесты"),
        tabCompanies("Компании");

        private String nameTab;

        SearchTitle(String nameButton) {this.nameTab = nameButton;}

        public String getText() {return nameTab;}

    }

    @Step("Проверка присутствия на странице текста: {nameCompany} ")
    public SearchPage checkCompanyIsPresent(String nameCompany) {
        WebElement element = driver.findElement(By.partialLinkText(nameCompany));
        Assertions.assertNotNull(element.getSize());

        return this;
    }

    @Override
    @Step("Загружаем страницу https://geekbrains.ru/search")
    public SearchPage openUrl() {
        driver.get("https://geekbrains.ru/search");
        return this;
    }
    public SearchTabsBlock getSearchTabsBlock() {
        return searchTabsBlock;
    }
}
