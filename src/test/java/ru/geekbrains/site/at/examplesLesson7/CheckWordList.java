package ru.geekbrains.site.at.examplesLesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckWordList {

    @Test
    void Check1() {

        WordList list1 = new WordList();
        list1.addWord("writer", "book","flour","book","hours","cat","book","cat");
        System.out.println(list1.findUniqueWords());
        list1.calculateDuplicatesWords();


    }

    @Test
    void Check2() {

        WordList list1 = new WordList();
        list1.addWord("writer");
        System.out.println(list1.findUniqueWords());
        list1.calculateDuplicatesWords();

    }
    @Test
    void Check3() {

        WordList list1 = new WordList();
        list1.addWord("","book","flour","book","hours","");
        System.out.println(list1.findUniqueWords());
        list1.calculateDuplicatesWords();

    }
    @Test
    void Check4() {

        WordList list1 = new WordList();
        list1.addWord();
        System.out.println(list1.findUniqueWords());
        list1.calculateDuplicatesWords();

    }
}
