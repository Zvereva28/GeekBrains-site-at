package ru.geekbrains.site.at.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.site.at.page.content.SearchPage;
import ru.geekbrains.site.at.blocks.Footer;
import ru.geekbrains.site.at.blocks.Header;
import ru.geekbrains.site.at.blocks.Navigation;
import ru.geekbrains.site.at.page.content.CoursesPage;
import ru.geekbrains.site.at.page.sign.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        }


  //  @Step("Проверка присутствия на  странице кнопки с текстом: {expectedText}")
    protected WebElement findElements(List<WebElement> listOfElements, String expectedText){
        List<String> arrayList = new ArrayList<>();
        for (WebElement webElement:listOfElements){//перебираем массив элементов
            String actualText = webElement.getText();//считываем тескм в каждого элемента
            arrayList.add(actualText);//добавляем в Лист - это на случай если кнопка не найдется
            if (actualText.toLowerCase().trim().equals(expectedText.toLowerCase().trim())){//сравниваем текст кнопки и ожидаемый текст
                return webElement;//возвращаем элемент с текстом
        }
    }
        throw new RuntimeException( "В коллекции элементов: " + arrayList + "\nНе найден элемент с тектом: " + expectedText);
    }
}

