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
            Simplify.simplifyAll(a, b, c, -1, -1);
        }

        c *= -1;
        equation = a + "x^2 + " + b + "x = " + c;
        steps.nextStep(equation);

    }

}
