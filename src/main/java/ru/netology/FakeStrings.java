package ru.netology;

import lombok.Data;

@Data
public class FakeStrings {
    private static String firstName;
    private static String lastName;
    private static String phone;
    private static String City;

    public static String getCity() {
        return City;
    }

    public static void setCity(String city) {
        City = city;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        FakeStrings.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        FakeStrings.lastName = lastName;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        FakeStrings.phone = phone;
    }
}
