package com.company;

public class QuadraticFormula {

    private String quadratic;
    Step steps = new Step();

    public QuadraticFormula(int a, int b, int c) {

        // First print of the quadratic in its entirety
        quadratic = (b * -1) + " +- √(" + b + "^2 - 4 * " + a + " * " + c + ")\n---------\n    2 * " + a;
        Step steps = new Step(quadratic);

        // Determines what the discriminant and denominator are and prints it
        int discriminant = (b * b) - (4 * a * c);
        System.out.println("\nDiscriminant: " + discriminant);
        int denominator = 2 * a;
        System.out.println("Denominator: " + denominator);

        // Prints the quadratic with a solved denominator and discriminant
        quadratic = (b * -1) + " +- √" + discriminant + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);

        // If the discriminant is a negative, it does the math for simplifying with i. If the discriminant is a positive, it does the math for finding 2 real solutions. If the discriminant is a 0, it solves for 1 real solution.
        if (discriminant < 0) {
            // simplify for incomplete
            negDiscriminant(a, b, c, discriminant, denominator);

        } else if (discriminant > 0) {
            // solve and simplify for 2 solutions
            posDiscriminant(a, b, c, discriminant, denominator);

        } else {
            // solve for 1 solution
            zeroDiscriminant(a, b, c, discriminant, denominator);
        }
    }

    // The math if the discriminant turns out to be negative. Shows the quadratic as simplified as can be.
    // The i isn't dealt with and only incorporated into the quadratic string. All rules required for imaginary numbers are used for the math.
    public void negDiscriminant(int a, int b, int c, int discriminant, int denominator) {
        // Uses abs() to pull the i out
        discriminant = Math.abs(discriminant);
        quadratic = (b *-1) + " +- i√" + discriminant + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);

        // Uses the returned outRoot to further simplify and keeps inRoot for the end product
        int[] nums = Simplify.simplifyRadical(discriminant);
        int inRoot = nums[1];
        int outRoot = nums[0];
        quadratic = (b *-1) + " +- " + outRoot + "i√" + inRoot + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);

        // Uses Simplify.simplifyAll()() to get a GCF, and then it's done
        int gcf = Simplify.simplifyAll(b, outRoot, denominator);
        quadratic = (b *-1)/gcf + " +- " + outRoot/gcf + "i√" + inRoot + "\n---------\n    " + denominator/gcf;
        steps.nextStep(quadratic);
    }

    // The math if the discriminant is positive. Gives two real solutions if discriminant is a whole square root.
    public void posDiscriminant(int a, int b, int c, int discriminant, int denominator) {
        quadratic = (b *-1) + " +- √" + discriminant + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);

        // uses returned inRoot and outRoot for further simplification and end result
        int[] nums = Simplify.simplifyRadical(discriminant);
        int inRoot = nums[1];
        int outRoot = nums[0];

        // If the number under the radical isn't 1, it will just simplify the quadratic with GCF and finish there
        if(inRoot != 1) {
            System.out.println("\nIF CHECKED.............................................");
            quadratic = (b *-1) + " +- " + outRoot + "√" + inRoot + "\n---------\n    " + denominator;
            steps.nextStep(quadratic);
            int gcf = Simplify.simplifyAll(a, b, c, outRoot, denominator);
            quadratic = (b *-1)/gcf + " +- " + outRoot/gcf + "√" + inRoot + "\n---------\n    " + denominator/gcf;
            steps.nextStep(quadratic);
            System.exit(69);
        }

        // Final quadratic form before splitting it into 2 paths for solving both X solutions
        quadratic = (b *-1) + " +- " + outRoot + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);

        // It begins
        System.out.println("\nSolving for two X solutions now...");

        // First solves for + to a string in case top isn't divisible by bottom
        quadratic = (b *-1) + " + " + outRoot + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);
        int top = (b*-1) + outRoot;
        quadratic = top + " / " + denominator;
        steps.nextStep(quadratic);
        String solution1;
        // If top isn't divisible by bottom...
        if(Math.abs(top) % denominator != 0) {
            solution1 = top + " / " + denominator;
        } else {
            solution1 = top / denominator + "";
        }

        // This half solves for the - part now for the second solution to x
        quadratic = (b *-1) + " - " + outRoot + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);
        top = (b*-1) - outRoot;
        quadratic = top + " / " + denominator;
        steps.nextStep(quadratic);
        String solution2;
        // If top isn't divisible by bottom...
        if(Math.abs(top) % denominator != 0) {
            solution2 = top + " / " + denominator;
        } else {
            solution2 = top / denominator + "";
        }

        // Prints solutions and then it's done
        System.out.println("x = " + solution1 + ", " + solution2);

    }

    // The math if the discriminant is 0
    public void zeroDiscriminant(int a, int b, int c, int discriminant, int denominator) {
        // With a discriminant of 0 (√0) it just leaves -b/2a so this sets up that new quadratic and prints it
        quadratic = (b *-1) + "\n---------\n    " + denominator;
        steps.nextStep(quadratic);

        // Assigns the solution to a string in case top isn't divisible by bottom, prints that and done
        String solution;
        if(Math.abs(b) % denominator != 0) {
            solution = (b*-1) + " / " + denominator;
        } else {
            solution = (b*-1) / denominator + "";
        }

        steps.nextStep(solution);
    }

}

