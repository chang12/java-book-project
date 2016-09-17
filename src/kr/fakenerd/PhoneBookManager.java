package kr.fakenerd;

import java.util.Scanner;

class PhoneBookManager {
    private static PhoneBookManager manager = null;

    static PhoneBookManager getInstance() {
        if (manager == null) {
            manager = new PhoneBookManager();
        }
        return manager;
    }

    private final int SIZE = 100;
    private PhoneInfo[] phoneInfos = new PhoneInfo[SIZE];
    private int phoneInfoNum = 0;
    private Scanner keyboard = new Scanner(System.in);

    private PhoneBookManager() {}

    int showMenu() {
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

    void insertPhoneInfo() {
        System.out.println("데이터 입력을 시작합니다..");
        System.out.println("1. 일반, 2. 대학, 3. 회사");
        System.out.print("선택>> ");
        int type = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        System.out.print("전화번호 : ");
        String phoneNumber = keyboard.nextLine();
        if (type == INSERT_MENU.NORMAL) {
            phoneInfos[phoneInfoNum++] = new PhoneInfo(name, phoneNumber);
        } else if (type == INSERT_MENU.UNIV) {
            System.out.print("전공 : ");
            String major = keyboard.nextLine();
            System.out.print("학년 : ");
            int year = keyboard.nextInt();
            keyboard.nextLine();
            phoneInfos[phoneInfoNum++] = new PhoneUnivInfo(name, phoneNumber, major, year);
        } else if (type == INSERT_MENU.COMPANY) {
            System.out.print("회사 : ");
            String company = keyboard.nextLine();
            phoneInfos[phoneInfoNum++] = new PhoneCompanyInfo(name, phoneNumber, company);
        }
        System.out.println("데이터 입력이 완료되었습니다.");
        System.out.println("");
    }

    void searchPhoneInfo() {
        System.out.println("데이터 검색을 시작합니다..");
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        for (int idx = 0; idx < phoneInfoNum; idx++) {
            if (name.equals(phoneInfos[idx].getName())) {
                phoneInfos[idx].showPhoneInfo();
                break;
            }
        }
        System.out.println("데이터 검색이 완료되었습니다.");
        System.out.println("");
    }

    void deletePhoneInfo() {
        System.out.println("데이터 삭제를 시작합니다..");
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        int idx;
        for (idx = 0; idx < phoneInfoNum; idx++) {
            if (name.equals(phoneInfos[idx].getName())) {
                break;
            }
        }
        if (idx == phoneInfoNum) {
            // 존재하지 않는 데이터의 삭제 요청이므로 작업할게 없다.
            return;
        }
        phoneInfoNum--;
        for (int i = idx; i < phoneInfoNum; i++) {
            phoneInfos[i] = phoneInfos[i + 1];
        }
        System.out.println("데이터 삭제가 완료되었습니다.");
        System.out.println("");
    }
}
