package kr.fakenerd;

import java.util.Scanner;

public class PhoneInfo {
    private String name;
    private String phoneNumber;
    private String birth;

    private static Scanner keyboard = new Scanner(System.in);

    public PhoneInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public PhoneInfo(String name, String phoneNumber, String birth) {
        this(name, phoneNumber);
        this.birth = birth;
    }

    public void showPhoneInfo() {
        System.out.println("name : " + name);
        System.out.println("phone : " + phoneNumber);
        if (birth != null) {
            System.out.println("birth : " + birth);
        }
        System.out.println("");
    }

    private static int showMenu() {
        System.out.println("선택하세요...");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 프로그램 종료");
        System.out.print("선택: ");
        int menu = keyboard.nextInt();
        keyboard.nextLine(); // 1 혹은 2를 입력한 뒤 누른 Enter 키는 nextInt로 흡수되지 않는다. 이를 버리는 역할.
        return menu;
    }

    private static PhoneInfo getPhoneInfo() {
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        System.out.print("전화번호 : ");
        String phoneNumber = keyboard.nextLine();
        System.out.print("생년월일 : ");
        String birth = keyboard.nextLine();
        System.out.println("");
        return new PhoneInfo(name, phoneNumber, birth);
    }

    public static void main(String[] args) {
        while (true) {
            int menu = showMenu();
            switch (menu) {
                case 1:
                    PhoneInfo pInfo = getPhoneInfo();
                    System.out.println("입력된 정보 출력...");
                    pInfo.showPhoneInfo();
                    break;
                case 2:
                    System.exit(0);
                default :
            }
        }
    }
}
