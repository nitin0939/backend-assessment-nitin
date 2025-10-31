package com.example;

public class Calculator {
    public static int add(String numbers) {
        if(numbers.isEmpty())
            return 0;

        String[] tokens = getTokens(numbers);
        int sum = 0;
        for(String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private static String[] getTokens(String numbers) {
        String delimiter = ",|\n";

        if(numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] tokens = numbers.split(delimiter);
        return tokens;
    }
}
