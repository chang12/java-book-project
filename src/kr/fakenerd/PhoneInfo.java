package kr.fakenerd;

import java.util.Scanner;

class PhoneInfo {
    private String name;
    private String phoneNumber;
    private String birth;

    private static Scanner keyboard = new Scanner(System.in);

    PhoneInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    PhoneInfo(String name, String phoneNumber, String birth) {
        this(name, phoneNumber);
        this.birth = birth;
    }

    void showPhoneInfo() {
        System.out.println("name : " + name);
        System.out.println("phone : " + phoneNumber);
        if (birth != null) {
            System.out.println("birth : " + birth);
        }
    }

    String getName() {
        return name;
    }
}
