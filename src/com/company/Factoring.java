package com.company;

public class Factoring {

    private int a;
    private int b;
    private int c;
    Step steps = new Step();
    private String equation;

    public Factoring(int passedA, int passedB, int passedC) {
        a = passedA;
        b = passedB;
        c = passedC;

        equation = a + "x^2 + " + b + "x + " + c + " = 0";
        steps.nextStep(equation);

        int[] aFactors = new int[0];
        int[] cFactors = new int[0];
        int iteration = 0;
        for(int i = a/2; i > 0; i++) {
            if(a % i == 0) {
                aFactors[iteration] = i;
            }
            iteration++;
        }
        iteration = 0;
        for(int i = c/2; i > 0; i++) {
            if(a % i == 0) {
                cFactors[iteration] = i;
            }
            iteration++;
        }

        for(int i = 0; i < aFactors.length; i++) {
            int aFactor1 = i;
            int aFactor2 = a / i;
            for(int j = 0; j < cFactors.length; j++) {
                int cFactor1 = j;
                int cFactor2 = j;
            }
        }

    }

}
