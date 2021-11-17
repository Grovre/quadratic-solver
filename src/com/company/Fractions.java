package com.company;

public class Fractions {

    private int numer;
    private int denom;
    private int[] numerRoot;
    private int[] denomRoot;

    // Constructor, just assigns object variable numer and denom to the arguments
    public Fractions(int numerator, int denominator) {
        numer = numerator;
        denom = denominator;
        // Makes sure that any two negatives will return a positive and the negative on the denominator moves to the numerator
        this.correctNegatives();
        System.out.println("New fraction created: " + this);
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
    public Fractions addFractions(Fractions fraction) {
        System.out.println("\n\n\nAdding Fractions");
        // assigning numer1 and denom1 keeps the original fraction, and correcting the negatives lets
        correctNegatives();
        fraction.correctNegatives();
        int numer1 = numer;
        int denom1 = denom;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();

        int lcd = getLCD(fraction);
        // Just makes sure the program doesn't die by killing it before it can die a painful death...
        if(lcd == 0) {
            System.out.println("LCD still 0");
            System.exit(1336);
        }

        // Assigns all the fraction number used to what they should be when setting up a problem like this on paper
        System.out.println("Factors: " + (lcd / denom) + " x " + (lcd / denom2));
        denom1 *= (lcd / denom);
        numer1 *= (lcd / denom);
        int temp = denom2;
        denom2 *= (lcd / denom2);
        numer2 *= (lcd / temp);

        System.out.println("LCD fractions: ");
        System.out.println("Fraction 1: " +numer1 + "/" + denom1 + "\nFraction 2: " + numer2 + "/" + denom2);

        Fractions newFraction = new Fractions((numer1 + numer2), denom1);
        newFraction = newFraction.simplifyFraction();
        return newFraction;
    }

    // Used to subtract fractions, lcd calculated and all. Lcm is for the first fraction
    public Fractions subtractFractions(Fractions fraction) {
        System.out.println("\n\n\nSubtracting Fractions");
        // assigning numer1 and denom1 keeps the original fraction, and correcting the negatives lets
        correctNegatives();
        fraction.correctNegatives();
        int numer1 = numer;
        int denom1 = denom;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int smallerDenom = Math.min(denom1, denom2);
        int largerDenom = Math.max(denom1, denom2);

        int lcd = getLCD(fraction);
        // Just makes sure the program doesn't die by killing it before it can die a painful death...
        if(lcd == 0) {
            System.out.println("LCD still 0");
            System.exit(1336);
        }

        // Assigns all the fraction number used to what they should be when setting up a problem like this on paper
        denom1 *= (lcd / denom);
        numer1 *= (lcd / denom);
        int temp = denom2;
        denom2 *= (lcd / denom2);
        numer2 *= (lcd / temp);
        System.out.println("LCD fractions: ");
        System.out.println("Fraction 1: " +numer1 + "/" + denom1 + "\nFraction 2: " + numer2 + "/" + denom2);

        Fractions newFraction = new Fractions((numer1 - numer2), denom1);
        newFraction = newFraction.simplifyFraction();
        return newFraction;
    }

    // Used to multiply fractions
    public Fractions multiplyFractions(Fractions fraction) {
        System.out.println("\n\n\nMultiplying Fractions");
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

    // Used to divide fractions, reciprocal and all
    public Fractions divideFractions(Fractions fraction) {
        System.out.println("\n\n\n Dividing Fractions");
        // Gets reciprocal by assigning numer and denom to their opposites 😈
        int denom2 = fraction.returnNumerator();
        int numer2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

    public Fractions simplifyFraction() {
        int gcf = Simplify.simplifyAll(numer, denom);

        if(gcf == 1) {
            return this;
        }
        return new Fractions(numer/gcf, denom/gcf);
    }

    public void correctNegatives() {
        if ((numer < 0 && denom < 0) || (numer > 0 && denom < 0)) {
            numer *= -1;
            denom *= -1;
        }
    }

    public void sqrt() {
        numerRoot = Simplify.simplifyRadical(numer);
        denomRoot = Simplify.simplifyRadical(denom);
    }

    public int[] returnNumerRoot() {
        return numerRoot;
    }

    public int[] returnDenomRoot() {
        return denomRoot;
    }

    // Returns the lCD
    public int getLCD(Fractions fraction2) {
        int denom1 = denom;
        int denom2 = fraction2.returnDenominator();
        int smallerDenom = Math.min(denom1, denom2);
        int largerDenom = Math.max(denom1, denom2);
        int i = largerDenom;
        int lcd;
        while(true) {
            if(i % largerDenom == 0 && i % smallerDenom == 0) {
                lcd = i;
                System.out.println("LCD found: " + lcd);
                return lcd;
            } else {
                i++;
            }
        }
    }

}
