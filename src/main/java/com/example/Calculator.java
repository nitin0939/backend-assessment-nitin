package com.example;

public class Calculator {
    public static int add(String numbers) {
        if(numbers.isEmpty())
            return 0;
        else if (numbers.contains(",")) {
            String tokens[] = numbers.split(",");
            return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
        }
        return Integer.parseInt(numbers);
    }
}
