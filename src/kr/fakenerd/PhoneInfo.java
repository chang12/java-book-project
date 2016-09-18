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

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        PhoneInfo comp = (PhoneInfo)obj;
        return name.equals(comp.getName());
    }
}
