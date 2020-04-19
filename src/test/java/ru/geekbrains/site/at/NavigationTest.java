//package ru.geekbrains.site.at;
//
//import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import ru.geekbrains.site.at.base.BaseTest;
//@DisplayName("Проверка системы навигации")
//@Ignore
//public class NavigationTest extends BaseTest {
    //    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера
//@Ignore
//    @DisplayName("Проверка перехода по кнопке курсы")
//    @Test
//    public void coursesNavigation(){
//        careerPage.startPageCareer();
//        careerPage.clickButton(Header.COURSES_BUTTON_SELECTOR);
//        Assertions.assertEquals("Курсы",coursesPage.getHeaderTitle());
//    }
//    @DisplayName("Проверка перехода по кнопке вебинвры")
//    @Test
//    public void eventsNavigation(){
//        careerPage.startPageCareer();
//        careerPage.clickButton(Header.EVENTS_BUTTON_SELECTOR);
//        Assertions.assertEquals("Вебинары",coursesPage.getHeaderTitle());
//    }
//@DisplayName("Проверка перехода по кнопке форум")
//@Test
//public void topicsNavigation(){
//    careerPage.startPageCareer();
//    careerPage.clickButton(Header.TOPICS_BUTTON_SELECTOR);
//    Assertions.assertEquals("Форум",coursesPage.getHeaderTitle());
//}
//@DisplayName("Проверка перехода по кнопке блог")
//@Test
//public void postsNavigation(){
//    careerPage.startPageCareer();
//    careerPage.clickButton(Header.POSTS_BUTTON_SELECTOR);
//    Assertions.assertEquals("Блог",coursesPage.getHeaderTitle());
//}
//
//}