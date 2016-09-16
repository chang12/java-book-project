package kr.fakenerd;

public class PhoneInfo {
    private String name;
    private String phoneNumber;
    private String birth;

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

    public static void main(String[] args) {
        PhoneInfo pInfo1 = new PhoneInfo("김철수", "111-2222", "92.12.02");
        PhoneInfo pInfo2 = new PhoneInfo("박영희", "333-4444", "92.12.02");
        pInfo1.showPhoneInfo();
        pInfo2.showPhoneInfo();
    }
}
