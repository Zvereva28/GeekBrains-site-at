package ru.geekbrains.site.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait10second;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait10second = new WebDriverWait(driver, 10);
        }

    protected WebElement findElement(List<WebElement> listOfElements, String expectedText){
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

