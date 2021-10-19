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
        equation = a + "x^2 + " + b + "x " + c + " = 0";
        steps.nextStep(equation);

        if(a != 1) {
            Simplify.simplifyAll(a, b, c);
        }

        c *= -1;
        equation = a + "x^2 + " + b + "x = " + c;
        steps.nextStep(equation);

        if(b % 2 != 0) {
            Fractions bOver2 = new Fractions(b, 2);
            Fractions cOver2 = new Fractions(c, 2);
            // The first fraction shows the bOver2 fraction squared and adding bOver2 to the right side of the equation. Long but not complicated
            equation = a + "x^2 + " + b + "x + " + (new Fractions(bOver2.returnNumerator() * bOver2.returnNumerator(), bOver2.returnDenominator() * bOver2.returnDenominator())) + " = " + cOver2  + " + " + bOver2;
            steps.nextStep(equation);
        }



    }

}
