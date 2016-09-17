package kr.fakenerd;

class PhoneCompanyInfo extends PhoneInfo {
    private String company;

    PhoneCompanyInfo(String name, String phoneNumber, String company) {
        super(name, phoneNumber);
        this.company = company;
    }

    @Override
    void showPhoneInfo() {
        super.showPhoneInfo();
        System.out.println("company : " + company);
    }
}
