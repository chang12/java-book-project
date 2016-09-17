package kr.fakenerd;

class PhoneUnivInfo extends PhoneInfo {
    private String major;
    private int year;

    PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
        super(name, phoneNumber);
        this.major = major;
        this.year = year;
    }

    @Override
    void showPhoneInfo() {
        super.showPhoneInfo();
        System.out.println("major : " + major);
        System.out.println("year : " + year);
    }
}
