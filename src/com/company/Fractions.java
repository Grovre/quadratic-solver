package com.company;

public class Fractions {

    private int numer;
    private int denom;

    // Constructor, just assigns object variable numer and denom to the arguments
    public Fractions(int numerator, int denominator) {
        numer = numerator;
        denom = denominator;
        // System.out.println("New fraction created: " + this.toString());
    }

    // Returns the numerator of the fraction object
    public int returnNumerator() {
        // System.out.println("Returning numerator");
        return numer;
    }

    // Returns the denominator of the fraction object
    public int returnDenominator() {
        // System.out.println("Returning denominator");
        return denom;
    }

    // Sets the numerator to a new int
    public void setNumerator(int newNumerator) {
        numer = newNumerator;
    }

    // Sets the denominator to a new int
    public void setDenominator(int newDenominator) {
        denom = newDenominator;
    }

    // Prints the fraction on one line as "numer/denom"
    @Override
    public String toString() {
        return numer + "/" + denom;
    }

    // Used to add fractions, lcd calculated and all. Lcm is for the first fraction
    public Object addFractions(Fractions fraction) {
        // System.out.println("\n\n\nAdding Fractions");
        int numer1 = numer;
        int denom1 = denom;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();

        // While loop searches for lcm. Works by setting lcd to any denominator (set to calling object's denom) * lcm. It then checks if the smaller denominator is a factor of the new lcd. If not, increase the lcm by 1 and repeat until one is found.
        boolean noLCD = true;
        int lcm = 1;
        int smallerDenom = Math.min(denom1, denom2);
        int largerDenom = Math.max(denom1, denom2);
        int lcd = 0;
        while (noLCD) {
            lcd = largerDenom * lcm;
            if (((double) lcd / smallerDenom) % 1 != 0) {
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

        // Assigns all the fraction number used to what they should be when setting up a problem like this on paper
        numer1 *= lcm;
        denom1 *= lcm;
        numer2 *= lcd / smallerDenom;
        denom2 *= lcd / smallerDenom;
        int gcf = Simplify.simplifyAll(numer1 + numer2, denom1);

        return new Fractions((numer1 += numer2)/gcf, denom1/gcf);
    }

    // Used to subtract fractions, lcd calculated and all. Lcm is for the first fraction
    public Object subtractFractions(Fractions fraction) {
        // System.out.println("\n\n\nSubtracting Fractions");
        int numer1 = numer;
        int denom1 = denom;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();

        // While loop searches for lcm. Works by setting lcd to any denominator (set to calling object's denom) * lcm. It then checks if the smaller denominator is a factor of the new lcd. If not, increase the lcm by 1 and repeat until one is found.
        boolean noLCD = true;
        int lcm = 1;
        int smallerDenom = Math.min(denom1, denom2);
        int largerDenom = Math.max(denom1, denom2);
        int lcd = 0;
        while (noLCD) {
            lcd = largerDenom * lcm;
            if (((double) lcd / smallerDenom) % 1 != 0) {
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

        // Assigns all the fraction number used to what they should be when setting up a problem like this on paper
        numer1 *= lcm;
        denom1 *= lcm;
        numer2 *= lcd / smallerDenom;
        denom2 *= lcd / smallerDenom;
        int gcf = Simplify.simplifyAll(numer1 - numer2, denom1);

        return new Fractions((numer1 -= numer2)/gcf, denom1/gcf);
    }

    // Used to multiply fractions
    public Object multiplyFractions(Fractions fraction) {
        // System.out.println("\n\n\nMultiplying Fractions");
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

    // Used to divide fractions, reciprocal and all
    public Object divideFractions(Fractions fraction) {
        // System.out.println("\n\n\n Dividing Fractions");
        // Gets reciprocal by assigning numer and denom to their opposites 😈
        int denom2 = fraction.returnNumerator();
        int numer2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

}
