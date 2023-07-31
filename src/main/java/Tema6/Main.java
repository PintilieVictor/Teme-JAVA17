package Tema6;

import Tema6.DistanceCalculator;

import java.util.Scanner; class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the expression:");
        String expression = scanner.nextLine();

        double result = DistanceCalculator.evaluateExpression(expression);
        System.out.println("Result: " + result);

        runTests();
    }

    public static <DistanceCalculatorTest> void runTests() {
        DistanceCalculatorTest calculatorTest = new DistanceCalculatorTest();
        calculatorTest.testEvaluateExpression();
        calculatorTest.testConvertToMeters();
    }
}