package com.company;

public class Simplify {

    // Simplifies all the numbers except for what's under the radical with a GCF. Math.abs() used so negatives don't fool the system.
    // Pass 1 or -1 if it's an empty space. If there's a 1 or -1, it won't simplify anyways.
    public static int simplifyAll(int a, int b, int c, int d, int e) {
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        d = Math.abs(d);
        e = Math.abs(e);
        // This for loop gets the absolute smallest number passed and descends by 1 until 1 to find a GCF.
        // Simplifies 5 nums
        for(int gcf = Math.min(a,Math.min(b,Math.min(c,Math.min(d,e)))); gcf > 1; gcf--) {
            // if all the numbers are divisible by i...
            System.out.println("Testing GCF " + gcf + ".");
            if(a % gcf == 0 &&
                    b % gcf == 0 &&
                    c % gcf == 0 &&
                    d % gcf == 0 &&
                    e % gcf == 0) {
                System.out.println("Test checked.");
                System.out.println("GCF: " + gcf);
                return gcf;
            }
        }
        System.out.println("No GCF");
        return 1;
    }

    // Simplifies 4 nums
    public static int simplifyAll(int a, int b, int c, int d) {
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        d = Math.abs(d);
        // This for loop gets the absolute smallest number passed and descends by 1 until 1 to find a GCF.
        for(int gcf = Math.min(a,Math.min(b,Math.min(c,d))); gcf > 1; gcf--) {
            // if all the numbers are divisible by i...
            System.out.println("Testing GCF " + gcf + ".");
            if(a % gcf == 0 &&
                    b % gcf == 0 &&
                    c % gcf == 0 &&
                    d % gcf == 0) {
                System.out.println("Test checked.");
                System.out.println("GCF: " + gcf);
                return gcf;
            }
        }
        System.out.println("No GCF");
        return 1;
    }

    // Simplifies 3 nums
    public static int simplifyAll(int a, int b, int c) {
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        // This for loop gets the absolute smallest number passed and descends by 1 until 1 to find a GCF.
        for(int gcf = Math.min(a,Math.min(b,c)); gcf > 1; gcf--) {
            // if all the numbers are divisible by i...
            System.out.println("Testing GCF " + gcf + ".");
            if(a % gcf == 0 &&
                    b % gcf == 0 &&
                    c % gcf == 0) {
                System.out.println("Test checked.");
                System.out.println("GCF: " + gcf);
                return gcf;
            }
        }
        System.out.println("No GCF");
        return 1;
    }

    // Simplifies 2 nums
    public static int simplifyAll(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        // This for loop gets the absolute smallest number passed and descends by 1 until 1 to find a GCF.
        for(int gcf = Math.min(a,b); gcf > 1; gcf--) {
            // if all the numbers are divisible by i...
            System.out.println("Testing GCF " + gcf + ".");
            if(a % gcf == 0 && b % gcf == 0) {
                System.out.println("Test checked.");
                System.out.println("GCF: " + gcf);
                return gcf;
            }
        }
        System.out.println("No GCF");
        return 1;
    }

    // Returns A and B in Ai√B. If you want to understand this and the comments completely, see khan academy or mathsisfun https://www.mathsisfun.com/numbers/simplify-square-roots.html
    // inRoot is the number under the radical and outRoot is the number outside the radical (ex. out√in)
    public static int[] simplifyRadical(int inRoot) {
        // outRoot is always 1 at first (ex. 1√72 == √72)
        int outRoot = 1;
        // Loops with i ascending but going no further than √inRoot. √inRoot works as the max i because any number greater than √inRoot when squared will be greater than inRoot, meaning inRoot % (i*i) will always be false no matter what. Using √inRoot as a ceiling only does as many iterations as it needs to for checking perfect square factors.
        for(int i = 2; i < (int) Math.sqrt(inRoot)+1; i++) {
            System.out.println("Checking if " + inRoot + " % " + (i*i) + " == 0 (" + i + "^2)");
            // You need a perfect square factor of the number inside the radical to be able to simplify it further. i is the perfect square root of a factor which is why i*i.
            if(inRoot % (i*i) == 0) {
                System.out.print("Yes, ");
                // You need to multiply the number outside the radical by the perfect square root used according to maf rules.
                outRoot *= i;
                // You need to divide the number under the radical by the perfect square to get the new number under the radical
                inRoot /= i*i;
                // Sets i back to 1 to begin the next iteration at 2 and continue simplifying the radical
                i = 1;
                System.out.println("radical is now " + outRoot + "√" + inRoot);
            }
        }
        System.out.println("Returning " + outRoot + ", " + inRoot);
        return new int[] {outRoot, inRoot};
    }

}
