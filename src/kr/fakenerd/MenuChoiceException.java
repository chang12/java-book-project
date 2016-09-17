package kr.fakenerd;

class MenuChoiceException extends Exception{
    private int wrongChoice;

    MenuChoiceException(int menu) {
        wrongChoice = menu;
    }

    void showWrongChoice() {
        System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
    }
}
