package com.company;

public class test {
    public static void main(String[] args) {
        // Fractions test
         Fractions fraction1 = new Fractions(7, 8);
        Fractions fraction2 = new Fractions(10, 9);


        System.out.println("Addition: " + fraction1 + " + " + fraction2 + " = " + fraction1.addFractions(fraction2) + "\n\n");
        System.out.println("Subtraction: " + fraction1 + " - " + fraction2 + " = " + fraction1.subtractFractions(fraction2) + "\n\n");
        System.out.println("Multiplication: " + fraction1 + " * " + fraction2 + " = " + fraction1.multiplyFractions(fraction2) + "\n\n");
        System.out.println("Division: " + fraction1 + " / " + fraction2 + " = " + fraction1.divideFractions(fraction2) + "\n\n");


        // CompleteSquare test
        // new CompleteSquare(1, -4, 15);
    }
}
