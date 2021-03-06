package com.company;

public class Step {

    private int stepCount;
    private String simplifiedStep;

    // There are 4 different constructors for different scenarios of all possibilities
    public Step() {
        simplifiedStep = "";
        stepCount = 0;
    }

    public Step(String str) {
        simplifiedStep = str;
        stepCount = 0;
    }

    public Step(int num) {
        simplifiedStep = "";
        stepCount = num;
    }

    public Step(int num, String str) {
        simplifiedStep = str;
        stepCount = num;
    }

    // Sets the current str to print to the passed value, increments the step count by 1 and prints them
    public void nextStep(String str) {
        simplifiedStep = str;
        stepCount++;
        System.out.println();
        System.out.println(stepCount + ". \n");
        System.out.println(simplifiedStep);
    }

    // Sets the amount of steps and current str to print to the passed values and prints them
    public void nextStep(int num, String str) {
        simplifiedStep = str;
        stepCount = num;
        System.out.println();
        System.out.println(stepCount + ". \n");
        System.out.println(simplifiedStep);
    }

    // Overrides default toString()
    @Override
    public String toString() {
        return simplifiedStep;
    }

    // returns stepCount
    public int toInt() {
        return stepCount;
    }

    // prints amount of steps taken
    public void printStepCount() {
        System.out.println(stepCount);
    }

    // Returns stepCount
    public int returnStepCount() {
        return stepCount;
    }

    // prints str in simplifiedStep
    public void printString() {
        System.out.println(simplifiedStep);
    }

    // Returns String of current simplified step stored
    public String returnStepString() {
        return simplifiedStep;
    }

}
