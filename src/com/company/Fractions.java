package com.company;

public class Fractions {

    private int numer;
    private int denom;

    // Constructor, just assigns object variable numer and denom to the arguments
    public Fractions(int numerator, int denominator) {
        numer = numerator;
        denom = denominator;
        System.out.println("New fraction created: " + this.toString());
    }

    // Returns the numerator of the fraction object
    public int returnNumerator() {
        System.out.println("Returning numerator");
        return numer;
    }

    // Returns the denominator of the fraction object
    public int returnDenominator() {
        System.out.println("Returning denominator");
        return denom;
    }

    // Prints the fraction on one line
    @Override
    public String toString() {
        return numer + "/" + denom;
    }

    // Used to add fractions, lcd calculated and all. Lcm is for the first fraction
    public Object addFractions(Fractions fraction) {
        System.out.println("\n\n\nAdding Fractions");
        int numer1 = numer;
        int denom1 = denom;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();

        boolean noLCD = true;
        int lcm = 1;
        int toCompare = Math.min(denom1, denom2);
        int lcd = 0;
        while (noLCD) {
            lcd = denom1 * lcm;
            if (((double) lcd / toCompare) % 1 != 0) {
                lcm++;
            } else {
                noLCD = false;
            }
        }

        // Just makes sure the program doesn't die by killing it before it can die a painful death...
        if(lcd == 0) {
            System.out.println("LCD still 0");
            System.exit(1336);
        }

        numer1 *= lcm;
        denom1 *= lcm;
        numer2 *= lcd / toCompare;
        denom2 *= lcd / toCompare;

        return new Fractions(numer1 += numer2, denom1);
    }

    // Used to subtract fractions, lcd calculated and all. Lcm is for the first fraction
    public Object subtractFractions(Fractions fraction) {
        System.out.println("\n\n\nSubtracting Fractions");
        int numer1 = numer;
        int denom1 = denom;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();

        boolean noLCD = true;
        int lcm = 1;
        int toCompare = Math.min(denom1, denom2);
        int lcd = 0;
        while (noLCD) {
            lcd = denom1 * lcm;
            if (((double) lcd / toCompare) % 1 != 0) {
                lcm++;
            } else {
                noLCD = false;
            }
        }

        // Just makes sure the program doesn't die by killing it before it can die a painful death...
        if(lcd == 0) {
            System.out.println("LCD still 0");
            System.exit(1336);
        }

        numer1 *= lcm;
        denom1 *= lcm;
        numer2 *= lcd / toCompare;
        denom2 *= lcd / toCompare;

        return new Fractions(numer1 -= numer2, denom1);
    }

    // Used to multiply fractions
    public Object multiplyFractions(Fractions fraction) {
        System.out.println("\n\n\nMultiplying Fractions");
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

    // Used to divide fractions, reciprocal and all
    public Object divideFractions(Fractions fraction) {
        System.out.println("\n\n\n Dividing Fractions");
        // Reciprocal
        int denom2 = fraction.returnNumerator();
        int numer2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

}
