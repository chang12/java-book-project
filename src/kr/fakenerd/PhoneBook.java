package kr.fakenerd;

import java.util.Scanner;

public class PhoneBook {
    private static Scanner keyboard = new Scanner(System.in);
    private static final int INSERT = 1;
    private static final int SEARCH = 2;
    private static final int DELETE = 3;
    private static final int EXIT = 4;
    private static PhoneInfo[] phoneInfoArray = new PhoneInfo[100];
    private static int phoneInfoNum = 0;

    private static int showMenu() {
        System.out.println("선택하세요...");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택: ");
        int menu = keyboard.nextInt();
        keyboard.nextLine(); // 1 혹은 2를 입력한 뒤 누른 Enter 키는 nextInt로 흡수되지 않는다. 이를 버리는 역할.
        return menu;
    }

    private static void insertPhoneInfo() {
        System.out.println("데이터 입력을 시작합니다..");
        System.out.println("1. 일반, 2. 대학, 3. 회사");
        System.out.print("선택>> ");
        int type = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        System.out.print("전화번호 : ");
        String phoneNumber = keyboard.nextLine();
        if (type == 1) {
            phoneInfoArray[phoneInfoNum++] = new PhoneInfo(name, phoneNumber);
        } else if (type == 2) {
            System.out.print("전공 : ");
            String major = keyboard.nextLine();
            System.out.print("학년 : ");
            int year = keyboard.nextInt();
            keyboard.nextLine();
            phoneInfoArray[phoneInfoNum++] = new PhoneUnivInfo(name, phoneNumber, major, year);
        } else if (type == 3) {
            System.out.print("회사 : ");
            String company = keyboard.nextLine();
            phoneInfoArray[phoneInfoNum++] = new PhoneCompanyInfo(name, phoneNumber, company);
        }
        System.out.println("데이터 입력이 완료되었습니다.");
        System.out.println("");
    }

    private static void searchPhoneInfo() {
        System.out.println("데이터 검색을 시작합니다..");
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        for (int idx = 0; idx < phoneInfoNum; idx++) {
            if (name.equals(phoneInfoArray[idx].getName())) {
                phoneInfoArray[idx].showPhoneInfo();
                break;
            }
        }
        System.out.println("데이터 검색이 완료되었습니다.");
        System.out.println("");
    }

    private static void deletePhoneInfo() {
        System.out.println("데이터 삭제를 시작합니다..");
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        int idx;
        for (idx = 0; idx < phoneInfoNum; idx++) {
            if (name.equals(phoneInfoArray[idx].getName())) {
                break;
            }
        }
        if (idx == phoneInfoNum) {
            // 존재하지 않는 데이터의 삭제 요청이므로 작업할게 없다.
            return;
        }
        phoneInfoNum--;
        for (int i = idx; i < phoneInfoNum; i++) {
            phoneInfoArray[i] = phoneInfoArray[i + 1];
        }
        System.out.println("데이터 삭제가 완료되었습니다.");
        System.out.println("");
    }

    public static void main(String[] args) {
        while (true) {
            int menu = showMenu();
            switch (menu) {
                case INSERT:
                    insertPhoneInfo();
                    break;
                case SEARCH:
                    searchPhoneInfo();
                    break;
                case DELETE:
                    deletePhoneInfo();
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
