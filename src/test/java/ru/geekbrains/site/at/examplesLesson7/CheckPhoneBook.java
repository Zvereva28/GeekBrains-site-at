package ru.geekbrains.site.at.examplesLesson7;

import org.junit.jupiter.api.Test;

public class CheckPhoneBook {

    @Test
    void Check1() {

        PhoneBook book = new PhoneBook();
       book.addPhoneNumber("Smit", "35-69-98","69-87-69", "36-98-78");
        book.addPhoneNumber("Smit", "11-11-11");
        book.addPhoneNumber("simpson", "69-87-69");
        book.addPhoneNumber("simpson", "69-87-69");
        book.getNumbersByFamily("Smit");
        book.getNumbersByFamily("Smi");
        book.getNumbersByFamily("simpson");
        

    }
}
