package Tema4;
class Typeofsmartphone extends TypeOfPhone {
    public Typeofsmartphone(String brandName) {
        super(brandName);
    }

    public PhoneModel createPhoneModel() {
        return new Phonefunctions(brandName + " Model");
    }
}
