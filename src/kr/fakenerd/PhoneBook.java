package kr.fakenerd;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBookManager manager = PhoneBookManager.getInstance();

        while (true) {
            try {
                int menu = manager.showMenu();
                switch (menu) {
                    case MENU.INSERT:
                        manager.insertPhoneInfo();
                        break;
                    case MENU.SEARCH:
                        manager.searchPhoneInfo();
                        break;
                    case MENU.DELETE:
                        manager.deletePhoneInfo();
                        break;
                    case MENU.EXIT:
                        System.exit(0);
                }
            } catch (MenuChoiceException e) {
                e.showWrongChoice();
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                System.out.println("");
            }
        }
    }
}
