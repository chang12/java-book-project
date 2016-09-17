package kr.fakenerd;

import java.util.Scanner;

class PhoneInfo {
    private String name;
    private String phoneNumber;

    private static Scanner keyboard = new Scanner(System.in);

    PhoneInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    void showPhoneInfo() {
        System.out.println("name : " + name);
        System.out.println("phone : " + phoneNumber);
    }

    String getName() {
        return name;
    }
}
