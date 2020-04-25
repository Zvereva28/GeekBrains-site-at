package ru.geekbrains.site.at.examplesLesson7;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList<String>> hm = new HashMap<>();
    public PhoneBook(){

    }
    public void addPhoneNumber(String FamilyName, String... numbers){
        if (hm.get(FamilyName) != null){
            for (String number : numbers) {
                hm.get(FamilyName).add(number);}


        }
        else { ArrayList<String> newList = new ArrayList<>();
                for (String number : numbers) {
                    newList.add(number);
                }
                hm.put(FamilyName,newList);

            }
        }

    public void getNumbersByFamily(String searchFamily){
        System.out.println(searchFamily + "   соответствует номерам    " + hm.get(searchFamily));
    }
}
