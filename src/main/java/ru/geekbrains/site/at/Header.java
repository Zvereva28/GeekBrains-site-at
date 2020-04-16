package ru.geekbrains.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Header {
    protected WebDriver driver;
    public static final By COURSES_BUTTON_SELECTOR = By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]");//курсы
    public static final By EVENTS_BUTTON_SELECTOR = By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/events\"]");//вебинары
    public static final By TOPICS_BUTTON_SELECTOR = By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/topics\"]");//форум
    public static final By POSTS_BUTTON_SELECTOR = By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]");//блог
    public static final By TESTS_BUTTON_SELECTOR = By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/tests\"]");//тесты
    public static final By CAREER_BUTTON_SELECTOR = By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/career\"]");//карьера

    static final By HEADER_TITLE_FIELD_SELECTOR = By.cssSelector("[class=\"gb-header__title\"]");//заголовок в хэдере
    // конструктор абстрактного класса
    public Header(WebDriver driver) {
        this.driver = driver;
    }

public void clickButton(By selector){
    WebElement buttonCourses = driver.findElement(selector);
    buttonCourses.click();
}

public String getHeaderTitle(){
    return driver.findElement(HEADER_TITLE_FIELD_SELECTOR).getText();

}


}
