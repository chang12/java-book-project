package kr.fakenerd;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBookManager manager = PhoneBookManager.getInstance();

        while (true) {
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
        }
    }
}
