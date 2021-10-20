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

        // newC is bFraction divided by 2, cFraction is what previously was c * -1 to account for the operation to move it over
        // (a)x^2 + (bFraction)x + (newC)^2 = (cFraction) + newC
        cFraction.setNumerator(cFraction.returnNumerator() * -1);
        Fractions newC = bFraction.divideFractions(new Fractions(2, 1));
        equation = a + "x^2 + " + bFraction + "x + " + newC.returnNumerator()*newC.returnNumerator() + "/" + newC.returnDenominator()* newC.returnDenominator() + " = " + cFraction + " + " + newC;
        steps.nextStep(equation);

        cFraction = cFraction.addFractions(newC);
        equation = "(x + " + newC + ")^2 = " + cFraction;
        steps.nextStep(equation);
    }

}
