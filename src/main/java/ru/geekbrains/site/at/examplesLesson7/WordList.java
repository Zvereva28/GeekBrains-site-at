package ru.geekbrains.site.at.examplesLesson7;
import java.util.*;

public class WordList {
    ArrayList<String> wordsList = new ArrayList<>();

    public WordList() {

    }

    public HashSet<String> findUniqueWords() {
        HashSet<String> set = new HashSet<>();
//        if (this.wordsList.size() < 2) {
//            return set;
//        }

        for (String word : this.wordsList) {
            set.add(word);
        }
        return set;
    }

    public void calculateDuplicatesWords() {
        HashSet<String> set = this.findUniqueWords();
        HashMap<String, Integer> hm = new HashMap<>();

        for (String uniqueWord : set) {
            int n = 0;
            for (String word : this.wordsList) {
                if (uniqueWord.equals(word)) {
                    n = n + 1;
                }
            }
            if (n > 1) {
                System.out.println("слово - " + uniqueWord + "  встречается " + n + " раз");
            }
        }
    }

    public void addWord(String... words) {
        for (String word : words) {
            wordsList.add(word);
        }
    }
}
