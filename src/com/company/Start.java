package com.company;


import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        // Gets the A, B and C of someone's trinomial
        Scanner input = new Scanner(System.in);

        System.out.println("What is A (Ax^2)");
        int a = input.nextInt();

        System.out.println("What is B (Bx)");
        int b = input.nextInt();

        System.out.println("What is C (C)?");
        int c = input.nextInt();

        // A just cannot be 0.
        if(a == 0) {
            System.out.println("A cannot be zero.");
            System.exit(69);
        }

        QuadraticFormula mathMethod = new QuadraticFormula(a, b, c);

        /*// Determines which method to solve step-by-step
        System.out.println("Which method would you like to use? Quadratic Formula (0), Completing the Square (1), ");
        if(input.nextInt() == 0) {
            QuadraticFormula mathMethod = new QuadraticFormula(a, b, c);
        } else if (input.nextInt() == 1) {
            CompleteSquare mathMethod = new CompleteSquare(a, b, c);
        }*/
    }
}