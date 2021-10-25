package com.company;

public class Factoring {

    private int a;
    private int b;
    private int c;
    private int ac;
    Step steps = new Step();
    private String equation;

    public Factoring(int passedA, int passedB, int passedC) {
        a = passedA;
        b = passedB;
        c = passedC;
        ac = a * c;

        // Step 1, basic quadratic equation
        equation = a + "x^2 + " + b + "x + " + c + " = 0";
        steps.nextStep(equation);

        // Uses ac in the equation instead of c
        equation = "1x^2 + " + b + "x + " + ac + " = 0";
        steps.nextStep(equation);

        // Finds the factors and puts them into array acFactors
        int[] acFactors = new int[ac / 2 + 1];
        int addedFactorCount = 0;
        int iteration = 0;
        // Loops through every number in descending order starting from the halfway point of ac to find factors of ac
        for (int i = Math.abs(ac / 2); i > 0; i--) {
            System.out.println("Iteration " + iteration + " of finding factors");
            System.out.println("i = " + i);
            System.out.println("Checking if " + ac + " / " + i + " works");
            if (ac % i == 0) {
                acFactors[addedFactorCount] = Math.abs(i);
                System.out.println("adding " + Math.abs(i) + " to acFactors (" + Math.abs(i) + " x " + ac / Math.abs(i) + ")");
                addedFactorCount++;
            } else {
                System.out.println("No");
            }
            iteration++;
            System.out.println();
        }

        // Slide and Divide
        System.out.println("Beginning slide and divide method");
        int a1 = a;
        int a2 = 1;
        // Loops through all possible factors of ac until 2 factors add or subtract to
        for (int i = 0; i < acFactors.length; i++) {
            if(acFactors[i] == 0) { continue; }
            System.out.println("\nIndex " + i + " ac factors");
            a1 = acFactors[i];
            a2 = ac / a1;
            System.out.println("Testing " + a1 + " and " + a2);
            if ( (a1 + a2 == b) || (a1 - a2 == b) || (a2 - a1 == b) ) {
                System.out.println("Found a factor that adds or subtracts into b: " + a1 + ", " + a2);
                break;
            }
        }
        equation = "(x + " + a1 + ")(x + " + a2 + ") = 0";
        steps.nextStep(equation);

        // Creates fractions to divide the factors that add or subtract by a
        Fractions a1Fraction = new Fractions(a1, a);
        Fractions a2Fraction = new Fractions(a2, a);
        equation = "(x + " + a1Fraction + ")(x + " + a2Fraction + ") = 0";
        steps.nextStep(equation);

        // Simplifies the fractions
        a1Fraction = a1Fraction.simplifyFraction();
        a2Fraction = a2Fraction.simplifyFraction();
        equation = "(x + " + a1Fraction + ")(x + " + a2Fraction + ") = 0";
        steps.nextStep(equation);

        // Moves the denominator over to the coefficient of x by setting a1 and a2 to the fraction numerators and using the denominators as the coefficients
        a1 = a1Fraction.returnNumerator();
        a2 = a2Fraction.returnNumerator();
        equation = "(" + a1Fraction.returnDenominator() + "x + " + a1 + ")" + "(" + a2Fraction.returnDenominator() + "x + " + a2 + ") = 0";
        steps.nextStep(equation);

        int stepCount = steps.returnStepCount();
        // Solves for the first x
        equation = a1Fraction.returnDenominator() + "x + " + a1 + " = 0";
        steps.nextStep(equation);
        a1 *= -1;
        equation = a1Fraction.returnDenominator() + "x = " + a1;
        steps.nextStep(equation);
        Fractions endFraction = new Fractions(a1, a1Fraction.returnDenominator());
        equation = "x = " + endFraction;
        steps.nextStep(equation);
        endFraction = endFraction.simplifyFraction();
        if(endFraction.returnDenominator() == 1) {
            equation = "x = " + endFraction.returnNumerator();
        } else {
            equation = "x = " + endFraction;
        }
        steps.nextStep(equation);

        // Solves for the second x
        equation = a2Fraction.returnDenominator() + "x + " + a2 + " = 0";
        steps.nextStep(stepCount, equation);
        a2 *= -1;
        equation = a2Fraction.returnDenominator() + "x = " + a2;
        steps.nextStep(equation);
        endFraction.setNumerator(a2);
        endFraction.setDenominator(a2Fraction.returnDenominator());
        equation = "x = " + endFraction;
        steps.nextStep(equation);
        endFraction = endFraction.simplifyFraction();
        if(endFraction.returnDenominator() == 1) {
            equation = "x = " + endFraction.returnNumerator();
        } else {
            equation = "x = " + endFraction;
        }
        steps.nextStep(equation);
    }
}
