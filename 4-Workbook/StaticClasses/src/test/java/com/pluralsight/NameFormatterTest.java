package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    public static void main(String[] args) {
        format_first_last_to_last_first_test();
        format_5_string_test();
        format_fullName_test();
    }
    public static void format_first_last_to_last_first_test() {
        String firstNameTest = "Clancy";
        String lastNameTest = "Long";
        String expectedFirstLast = NameFormatter.format(firstNameTest, lastNameTest);
        System.out.println(expectedFirstLast);

        String actualFirstLast = NameFormatter.format("Clancy", "Long");
        System.out.println(actualFirstLast);
        assertEquals(expectedFirstLast, actualFirstLast);
    }
    public static void format_5_string_test() {
        String firstNameTest = "Clancy";
        String lastNameTest = "Long";
        String middleNameTest = "Cooper";
        String prefixTest = "Mr.";
        String suffixTest = "Esq.";
        String expectedFiveString = NameFormatter.format(prefixTest, firstNameTest, middleNameTest, lastNameTest, suffixTest);
        System.out.println(expectedFiveString);


        String actualFiveString = NameFormatter.format("Mr.", "Clancy", "Cooper", "Long", "Esq.");
        System.out.println(actualFiveString);
        assertEquals(expectedFiveString, actualFiveString);
    }

    public static void format_fullName_test() {
        //Prefix[0] First[1] Last[2] Middle,[3] Suffix[4]
        String fullNameTest = "Mr. Clancy Long Cooper, Esq.";
        String expectedFullName = NameFormatter.format(fullNameTest);
        System.out.println(expectedFullName);

        String actualFullName = NameFormatter.format("Mr. Clancy Long Cooper, Esq.");
        System.out.println(actualFullName);
        assertEquals(expectedFullName, actualFullName);
    }
}