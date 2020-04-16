package ru.geekbrains.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends Header{
    public static final By TITLE_PROFESSIONS_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[2]/a");//профессии
    public static final By TITLE_COURSES_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[3]/a");//Курсы
    public static final By TITLE_WEBINARS_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[4]/a");//Вебинары
    public static final By TITLE_BLOG_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[5]/a");//Блоги
    public static final By TITLE_FORUM_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[6]/a");//Форумы
    public static final By TITLE_TESTS_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[7]/a");//Тесты
    public static final By TITLE_COMPANIES_BUTTON_SELECTOR = By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[8]/a");//Компании
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public Integer numberElementsTitleSearch(By selector){//"подсчет" количества элементов указанных в заголовке
        WebDriverWait wait = new WebDriverWait(driver, 40);

        WebElement buttonProf = driver.findElement(selector);
       // System.out.println(buttonProf.getText());
        String[] token = buttonProf.getText().split("・");
        int count = Integer.parseInt(token[1]);
        return count;
    }
}
