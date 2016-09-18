package kr.fakenerd;

import java.util.HashSet;
import java.util.Iterator;
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
    private HashSet<PhoneInfo> phoneInfos = new HashSet<>(SIZE);
    private Scanner keyboard = new Scanner(System.in);

    private PhoneBookManager() {}

    int showMenu() throws MenuChoiceException {
        System.out.println("선택하세요...");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택: ");
        int menu = keyboard.nextInt();
        keyboard.nextLine(); // 1 혹은 2를 입력한 뒤 누른 Enter 키는 nextInt로 흡수되지 않는다. 이를 버리는 역할.
        if (menu < MENU.INSERT || menu > MENU.EXIT) {
            throw new MenuChoiceException(menu);
        }
        return menu;
    }

    void insertPhoneInfo() throws MenuChoiceException {
        System.out.println("데이터 입력을 시작합니다..");
        System.out.println("1. 일반, 2. 대학, 3. 회사");
        System.out.print("선택>> ");
        int type = keyboard.nextInt();
        keyboard.nextLine();
        if (type < INSERT_MENU.NORMAL || type > INSERT_MENU.COMPANY) {
            throw new MenuChoiceException(type);
        }
        PhoneInfo info = null;
        System.out.print("이름 : ");
        String name = keyboard.nextLine();
        System.out.print("전화번호 : ");
        String phoneNumber = keyboard.nextLine();
        if (type == INSERT_MENU.NORMAL) {
            info = new PhoneInfo(name, phoneNumber);
        } else if (type == INSERT_MENU.UNIV) {
            System.out.print("전공 : ");
            String major = keyboard.nextLine();
            System.out.print("학년 : ");
            int year = keyboard.nextInt();
            keyboard.nextLine();
            info = new PhoneUnivInfo(name, phoneNumber, major, year);
        } else if (type == INSERT_MENU.COMPANY) {
            System.out.print("회사 : ");
            String company = keyboard.nextLine();
            info = new PhoneCompanyInfo(name, phoneNumber, company);
        }
        if (!phoneInfos.add(info)) {
            System.out.println("이미 저장된 데이터입니다.");
        } else {
            System.out.println("데이터 입력이 완료되었습니다.");
        }
        System.out.println("");
    }

    void searchPhoneInfo() {
        System.out.println("데이터 검색을 시작합니다..");
        System.out.print("이름 : ");
        String name = keyboard.nextLine();

        for (PhoneInfo info : phoneInfos) {
            if (name.equals(info.getName())) {
                info.showPhoneInfo();
                System.out.println("데이터 검색이 완료되었습니다.");
                System.out.println("");
                return;
            }
        }
        System.out.println("존재하지 않는 이름입니다.");
        System.out.println("");
    }

    void deletePhoneInfo() {
        System.out.println("데이터 삭제를 시작합니다..");
        System.out.print("이름 : ");
        String name = keyboard.nextLine();

        Iterator<PhoneInfo> iter = phoneInfos.iterator();
        while (iter.hasNext()) {
            if (name.equals(iter.next().getName())) {
                iter.remove();
                System.out.println("데이터 삭제가 완료되었습니다.");
                System.out.println("");
                return;
            }
        }
        System.out.println("존재하지 않는 이름입니다.");
        System.out.println("");
    }
}
