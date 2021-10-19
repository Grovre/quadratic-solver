package com.company;

public class test {
    public static void main(String[] args) {
        Fractions fraction1 = new Fractions(6, 8);
        Fractions fraction2 = new Fractions(2, 4);

        System.out.println(fraction1);
        System.out.println(fraction2);


        System.out.println("Add: " + fraction1 + " + " + fraction2 + " = " + fraction1.addFractions(fraction2));
        System.out.println("Subtract: " + fraction1 + " - " + fraction2 + " = " + fraction1.subtractFractions(fraction2));
        System.out.println("Multiply: " + fraction1 + " * " + fraction2 + " = " + fraction1.multiplyFractions(fraction2));
        System.out.println("Divide: " + fraction1 + " / " + fraction2 + " = " + fraction1.divideFractions(fraction2));

    }
}
