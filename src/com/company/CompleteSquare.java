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

        Fractions bOver2 = new Fractions(b, 2);
        int b2Numer = bOver2.returnNumerator()*bOver2.returnNumerator();
        int b2Denom = bOver2.returnDenominator()*bOver2.returnDenominator();
        Fractions cFraction = bOver2.addFractions(new Fractions(c, 1)).simplifyFraction();
        // cFraction = cFraction.simplifyFraction();
        equation = a + "x^2 + " + b + "x + " + b + b2Numer + "/" + b2Denom + " = " + cFraction;
        steps.nextStep(equation);

        if(cFraction.returnDenominator() == 1) {

        }

        // Useless right now, probably forever
        /*if(cFraction.returnDenominator() == 1) {
            cWhole = cFraction.returnNumerator();
            equation = a + "x^2 + " + b + "x + " + b + b2Numer + "/" + b2Denom + " = " + c + " + " + cWhole;
            steps.nextStep(equation);

            c += cWhole;
        } else {
            equation = a + "x^2 + " + b + "x + " + b + b2Numer + "/" + b2Denom + " = " + c + " + " + bOver2;
            steps.nextStep(equation);
        }*/



    }

}
