package Utilities.TestData;

import java.util.Random;

public class TestDataGenerator {
    public static String generateEmail() {
        return "NotReal" + new Random().nextInt(1000) + "@gmail.com";
    }

    public static String generatePassword() {
        return "MtPasswords" + new Random().nextInt(1000) + "!@#";
    }

}
