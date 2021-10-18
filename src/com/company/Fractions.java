package com.company;

@Deprecated // Incomplete
public class Fractions {

    private static int numer;
    private static int denom;

    // Constructor, just assigns object variable numer and denom to the arguments
    public Fractions(int numerator, int denominator) {
        numer = numerator;
        denom = denominator;
    }

    // Returns the numerator of the fraction object
    public int returnNumerator() {
        return numer;
    }

    // Returns the denominator of the fraction object
    public int returnDenominator() {
        return denom;
    }

    // Prints the fraction on one line
    @Override
    public String toString() {
        return numer + "/" + denom;
    }

    // Used to add fractions, lcd calculated and all. Lcm is for the first fraction
    public Object addFractions(Object fraction) {
        boolean noLCD = true;
        int lcm = 1;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int toCompare = Math.min(denom, denom2);
        int lcd = 0;
        while (noLCD) {
            lcd = denom * lcm;
            if (((double) lcd / toCompare) % 1 != 0) {
                lcm++;
            } else {
                noLCD = false;
            }
        }

        // Just makes sure the program doesn't die by killing it before it can die a painful death...
        if(lcd == 0) {
            System.out.println("LCD still 0");
            System.exit(1337);
        }

        // Temporary, to be removed
        final boolean CHECK = true;
        if(CHECK) {
            if((int) (numer * lcm) != numer * lcm) {
                System.out.println("numer is truncated");
                System.exit(1337);
            }
            if((int) (denom * lcm) != denom * lcm) {
                System.out.println("denom is truncated");
                System.exit(1338);
            }
            if((int) (numer2 * (lcd / toCompare)) != numer2 * (lcd / toCompare)) {
                System.out.println("numer2 is truncated");
                System.exit(1339);
            }
            if((int) (denom2 * (lcd / toCompare)) != denom2 * (lcd / toCompare)) {
                System.out.println("denom2 is truncated");
                System.exit(1340);
            }
        }

        numer *= lcm;
        denom *= lcm;
        numer2 *= lcd / toCompare;
        denom2 *= lcd / toCompare;

        return new Fractions(numer += numer2, denom);
    }

    // Used to subtract fractions, lcd calculated and all. Lcm is for the first fraction
    public Object subtractFractions(Object fraction) {
        boolean noLCD = true;
        int lcm = 1;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int toCompare = Math.min(denom, denom2);
        int lcd = 0;
        while (noLCD) {
            lcd = denom * lcm;
            if (((double) lcd / toCompare) % 1 != 0) {
                lcm++;
            } else {
                noLCD = false;
            }
        }

        // Just makes sure the program doesn't die by killing it before it can die a painful death...
        if(lcd == 0) {
            System.out.println("LCD still 0");
            System.exit(1337);
        }
        numer *= lcm;
        denom *= lcm;
        numer2 *= lcd / toCompare;
        denom2 *= lcd / toCompare;
        return new Fractions(numer -= numer2, denom);
    }

    // Used to multiply fractions
    public Object multiplyFractions(Object fraction) {
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int lcd = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/lcd, denom*denom2/lcd);
    }

    // Used to divide fractions, reciprocal and all
    public Object divideFractions(Object fraction) {
        // Reciprocal
        int denom2 = fraction.returnNumerator();
        int numer2 = fraction.returnDenominator();
        int lcd = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/lcd, denom*denom2/lcd);
    }

}
