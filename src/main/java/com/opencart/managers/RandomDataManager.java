package com.opencart.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {

    private static Faker fakerObject = new Faker();

    public static String generateRandomEmail(String prefix, String sufix) {
        String randomMidPart = String.valueOf(fakerObject.random().nextInt(1, 999999));
        return prefix + randomMidPart + sufix;
    }

    public static String generateRandomEmail() {
        return fakerObject.internet().emailAddress();
    }

    public static String generateFirstName() {
        return fakerObject.name().firstName();
    }

    public static String generateLastName() {
        return fakerObject.name().lastName();
    }

    public static String generatePhoneNumber() {
        return fakerObject.phoneNumber().phoneNumber();
    }

    public static String generatePassword() {
        return fakerObject.internet().password();
    }
}
