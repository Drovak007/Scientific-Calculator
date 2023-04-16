package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculos {
    // Variables
    private final MathContext mc = new MathContext(10);
    // Methods
    public BigDecimal sqrt(BigDecimal SciInput) {
        return SciInput.sqrt(mc);
    }

    public BigDecimal power2(BigDecimal SciInput) {
        return SciInput.pow(2, mc);
    }

    public BigDecimal power3(BigDecimal SciInput) {
        return SciInput.pow(3, mc);
    }

    public double exp(double SciInput) {
        return Math.exp(SciInput);
    }

    public double logn(double SciInput) {
        return Math.log(SciInput);
    }

    public BigInteger factorial(BigInteger SciInput) {
        if (SciInput.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return SciInput.multiply(factorial(SciInput.subtract(BigInteger.ONE)));
        }
    }

    public double sin(String SciInput) {
        BigDecimal input = new BigDecimal(SciInput);
        input = input.remainder(BigDecimal.valueOf(360), mc);
        double result = input.doubleValue();
        result = result * Math.PI / 180;
        return Math.sin(result);
    }

    public double cos(String SciInput) {
        BigDecimal input = new BigDecimal(SciInput);
        input = input.remainder(BigDecimal.valueOf(360), mc);
        double result = input.doubleValue();
        result = result * Math.PI / 180;
        return Math.cos(result);
    }

    public double tan(String SciInput) {
        BigDecimal input = new BigDecimal(SciInput);
        input = input.remainder(BigDecimal.valueOf(360), mc);
        double result = input.doubleValue();
        result = result * Math.PI / 180;
        return Math.tan(result);
    }

    public double sec(String SciInput) {
        BigDecimal input = new BigDecimal(SciInput);
        input = input.remainder(BigDecimal.valueOf(360), mc);
        double result = input.doubleValue();
        result = result * Math.PI / 180;
        return 1 / Math.cos(result);
    }

    public BigDecimal inverse(BigDecimal SciInput) {
        return BigDecimal.ONE.divide(SciInput, mc);
    }

    public BigDecimal percentage(BigDecimal SciInput) {
        return SciInput.divide(BigDecimal.valueOf(100), mc);
    }

    // Shunting Yard Algorithm
    // Converts an infix expression to a postfix expression and returns the result of the expression as a String
    // The logical algorithm can be found on the following link: https://en.wikipedia.org/wiki/Shunting_yard_algorithm
    public String dijkstraShuntingYard(String input) {
        // Variables
        ArrayList<String> outputQueue = new ArrayList<>();
        ArrayList<String> operatorStack = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        ArrayList<String> inputQueue = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> rawInput = new ArrayList<>(Arrays.asList(input.split("")));

        // Pre-processing of the input to correct numbers with more than one digit or decimal point
        for (String s : rawInput) {
            if (s.matches("[0-9.]")) {
                sb1.append(s);
            } else {
                if (!sb1.isEmpty()) {
                    inputQueue.add(sb1.toString());
                    sb1 = new StringBuilder();
                }
                inputQueue.add(s);
            }
        }
        if (!sb1.isEmpty()) {
            inputQueue.add(sb1.toString());
            sb1 = new StringBuilder();
        }

        // Shunting Yard Algorithm made by Edsger Dijkstra to convert infix to postfix
        for (String s : inputQueue) {
            switch (s) {
                case "+", "-", "*", "/", "^" -> {
                    if (!sb1.isEmpty()) {
                        outputQueue.add(sb1.toString());
                        sb1 = new StringBuilder();
                    }
                    while (!operatorStack.isEmpty() && !operatorStack.get(operatorStack.size()-1).equals("(") && (verifyPrecedenceBiggerThan(s, operatorStack.get(operatorStack.size()-1)) || (verifyPrecedenceEqualTo(s, operatorStack.get(operatorStack.size()-1)) && !s.equals("^")))) {
                        outputQueue.add(operatorStack.get(operatorStack.size() - 1));
                        operatorStack.remove(operatorStack.size() - 1);
                    }
                    operatorStack.add(s);
                }
                case "(" -> {
                    if (!sb1.isEmpty()) {
                        outputQueue.add(sb1.toString());
                        sb1 = new StringBuilder();
                    }
                    operatorStack.add(s);
                }
                case ")" -> {
                    if (!sb1.isEmpty()) {
                        outputQueue.add(sb1.toString());
                        sb1 = new StringBuilder();
                    }
                    while (!operatorStack.get(operatorStack.size() - 1).equals("(")) {
                        if (operatorStack.isEmpty()) {
                            return null;
                        }
                        outputQueue.add(operatorStack.get(operatorStack.size() - 1));
                        operatorStack.remove(operatorStack.size() - 1);
                    }
                    operatorStack.remove(operatorStack.size() - 1);
                    if (operatorStack.get(operatorStack.size() - 1).equals("^")) {
                        outputQueue.add(operatorStack.get(operatorStack.size() - 1));
                        operatorStack.remove(operatorStack.size() - 1);
                    }
                }
                default -> sb1.append(s);
            }
        }
        if (!sb1.isEmpty()) {
            outputQueue.add(sb1.toString());
        }
        while (!operatorStack.isEmpty()) {
            if (operatorStack.get(operatorStack.size() - 1).equals("(")) {
                return null;
            }
            outputQueue.add(operatorStack.get(operatorStack.size() - 1));
            operatorStack.remove(operatorStack.size() - 1);
        }

        // Calculate the result of the postfix expression
        for (String s : outputQueue) {
            switch (s) {
                case "+", "-", "*", "/" -> {
                    double a = Double.parseDouble(result.get(result.size() - 2));
                    double b = Double.parseDouble(result.get(result.size() - 1));
                    result.remove(result.size() - 1);
                    result.remove(result.size() - 1);
                    switch (s) {
                        case "+" -> result.add(String.valueOf(a + b));
                        case "-" -> result.add(String.valueOf(a - b));
                        case "*" -> result.add(String.valueOf(a * b));
                        case "/" -> result.add(String.valueOf(a / b));
                    }
                }
                case "^" -> {
                    double c = Double.parseDouble(result.get(result.size() - 2));
                    double d = Double.parseDouble(result.get(result.size() - 1));
                    result.remove(result.size() - 1);
                    result.remove(result.size() - 1);
                    result.add(String.valueOf(Math.pow(c, d)));
                }
                default -> result.add(s);
            }
        }
        return result.get(0);
    }

    // Verify if precedence of operator2 is higher than operator1. If so, return true.
    public boolean verifyPrecedenceBiggerThan(String operator1, String operator2) {
        if (operator2.equals("^")) {
            return true;
        } else return operator2.matches("[*/]") && operator1.matches("[+-]");
    }
    // Verify if precedence of operator2 is equal to operator1. If so, return true.
    public boolean verifyPrecedenceEqualTo(String operator1, String operator2) {
        if (operator1.equals("^")) {
            return operator1.equals(operator2);
        } else return operator1.matches("[*/+-]") && operator2.equals(operator1);
    }
}
