
package com.company;

@Deprecated // Incomplete
public class Fractions {

    private static int numer;
    private static int denom;

    public Fractions(int numerator, int denominator) {
        numer = numerator;
        denom = denominator;
    }

    public int returnNumerator() {
        return numer;
    }

    public int returnDenominator() {
        return denom;
    }

    @Override
    public String toString() {
        return numer + "/" + denom;
    }

    public Object addFractions(Object fraction) {
        boolean noGCF = true;
        int i = 1;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        while (noGCF) {
            if (denom * i != denom2 * i) {
                i++;
            } else {
                noGCF = false;
            }
        }
        return new Fractions((i*numer)+(i*numer2), i);
    }

    public Object subtractFractions(Object fraction) {
        boolean noGCF = true;
        int i = 1;
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        while (noGCF) {
            if (denom * i != denom2 * i) {
                i++;
            } else {
                noGCF = false;
            }
        }
        return new Fractions(Math.abs((i*denom)-(i*denom2)), i);
    }

    public Object multiplyFractions(Object fraction) {
        int numer2 = fraction.returnNumerator();
        int denom2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom*denom2);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

    public Object divideFractions(Object fraction) {
        // Reciprocal
        int denom2 = fraction.returnNumerator();
        int numer2 = fraction.returnDenominator();
        int gcf = Simplify.simplifyAll(numer*numer2, denom2*denom);
        return new Fractions(numer*numer2/gcf, denom*denom2/gcf);
    }

}
