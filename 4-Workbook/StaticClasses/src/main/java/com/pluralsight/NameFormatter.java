package com.pluralsight;

public class NameFormatter {
    private String prefix, firstName, middleName, lastName, suffix, fullName;

    public NameFormatter(String prefix, String firstName, String middleName, String lastName, String suffix) {
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.fullName = fullName;
    }

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        return lastName + ", " + prefix + " " + firstName + " " + middleName + ", " + suffix;
    }

    public static String format(String fullName) {
        //from - >Prefix[0] First[1] Last[2] Middle,[3] Suffix[4]
        //to -> Last +,[2] Prefix[0] First[1] Middle,[3] Suffix[4]
        String[] splitName = fullName.split(" ");
        return splitName[2] + ", " + splitName[0] + " " + splitName[1] + " " + splitName[3] + " " + splitName[4];

    }
}
