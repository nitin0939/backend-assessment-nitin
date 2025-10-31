package com.example;

import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String numbers) {
        if(numbers.isEmpty())
            return 0;

        String[] tokens = getTokens(numbers);
        List<Integer> negatives = new java.util.ArrayList<>();
        int sum = 0;
        for(String token : tokens) {
            int number = Integer.parseInt(token);
            if(number < 0) {
                negatives.add(number);
            } else {
                if(1000 < sum + number)
                    return sum;
                sum += number;
            }
        }
        if(!negatives.isEmpty()) {
            throw new RuntimeException("negatives not allowed " + negatives.toString().replace("[", "").replace("]", ""));
        }
        return sum;
    }

    private static String[] getTokens(String numbers) {
        String delimiter = ",|\n";

        if(numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = Pattern.quote(numbers.substring(2, delimiterEnd));
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] tokens = numbers.split(delimiter);
        return tokens;
    }
}
