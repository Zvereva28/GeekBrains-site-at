package ru.geekbrains.site.at.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
//        WebDriverManager.chromedriver().setup();//просим библиотеку webdrivermanager скачать хром (версию система узнает самостоятельно)

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));// создаем опции для отключения всплывающих окон
        driver = new ChromeDriver(options);//создаем экземпляр хромдрайвера и передаем в него опции
        driver.manage().window().maximize();//разворачиваем окно на весь экран
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// ожидание 10 секунд
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }//закрытие драйвера
}