package Tema4;

public class Main {
    public static void main(String[] args) {
        TypeOfPhone samsungBrand = new Typeofsmartphone("Samsung");
        TypeOfPhone appleBrand = new Typeofsmartphone("Apple");

        TypeOfPhone samsungModel1 = samsungBrand;
        TypeOfPhone samsungModel2 = samsungBrand;
        TypeOfPhone appleModel1 = appleBrand;
        TypeOfPhone appleModel2 = appleBrand;

    }
}
