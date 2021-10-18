package com.company;

public class test {
    public static void main(String[] args) {
        Fractions fraction1 = new Fractions(1, 2);
        Fractions fraction2 = new Fractions(2, 4);

        Object newFraction = fraction1.addFractions(fraction2);
        System.out.println(newFraction);
    }
}
