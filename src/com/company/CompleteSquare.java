package com.company;

@Deprecated // Incomplete
public class CompleteSquare {

    private String equation;
    private int a;
    private int b;
    private int c;
    private Step steps = new Step();

    // constructor, pass as Ax + Bx + C = 0
    public CompleteSquare(int passedA, int passedB, int passedC) {
        a = passedA;
        b = passedB;
        c = passedC;
        equation = a + "x^2 + " + b + "x + " + c + " = 0";
        steps.nextStep(equation);

        // Sets everything over a no matter what, that way all the math can be done with class Fractions methods
        Fractions bFraction = new Fractions(b, a);
        Fractions cFraction = new Fractions(c, a);
        a = 1;
        equation = a + "x^2 + " + bFraction + "x + " + cFraction + " = 0";
        steps.nextStep(equation);

        // newC is bFraction divided by 2, cFraction is what previously was c now multiplied by a negative to account for the operation to move it over
        // (a)x^2 + (bFraction)x + newCsquared = (cFraction) + newCsquared
        // This moves c over as a fraction
        cFraction.setNumerator(cFraction.returnNumerator() * -1);
        // newC is c/2 used in the factor made from the quadratic equation
        Fractions newC = bFraction.divideFractions(new Fractions(2, 1));
        // newCsquared is newC squared which is added on both sides, once in place of c and once to be added to cFraction
        Fractions newCsquared = new Fractions(bFraction.returnNumerator() * bFraction.returnNumerator(), bFraction.returnDenominator() * bFraction.returnDenominator());
        equation = a + "x^2 + " + bFraction + "x + " + newCsquared + " = " + cFraction + " + " + newCsquared;
        steps.nextStep(equation);

        // Adds c and (c/2)^2 together
        cFraction = cFraction.addFractions(newCsquared);
        equation = "(x + " + newC + ")^2 = " + cFraction;
        steps.nextStep(equation);

        // If cFraction is not a perfect square
        if((cFraction.getNumerRoot()[1] != 1) || (cFraction.getDenomRoot()[1] != 1)) {
            // Adds the square root signs (√) to the equation for further simplification
            equation = "x + " + newC + " = +- " + cFraction.getNumerRoot()[0] + "√" + cFraction.getNumerRoot()[1] + "/" + cFraction.getDenomRoot()[0] + "√" + cFraction.getDenomRoot()[1];
            steps.nextStep(equation);

            // Moves newC over
            newC.setNumerator(newC.returnNumerator() * -1);
            equation = "x = " + newC + " +- " + cFraction.getNumerRoot()[0] + "√" + cFraction.getNumerRoot()[1] + "/" + cFraction.getDenomRoot()[0] + "√" + cFraction.getDenomRoot()[1];
            steps.nextStep(equation);


        }
    }

}
