package com.example;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
            } else if(number <= 1000) {
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
            String delimiterPart = numbers.substring(2, delimiterEnd);
            
            if(delimiterPart.contains("[")) {
                java.util.List<String> delimiters = new java.util.ArrayList<>();
                Matcher matcher = Pattern.compile("\\[([^\\]]+)\\]").matcher(delimiterPart);
                while(matcher.find()) {
                    delimiters.add(Pattern.quote(matcher.group(1)));
                }
                delimiter = String.join("|", delimiters);
            } else {
                delimiter = Pattern.quote(delimiterPart);
            }
            
            numbers = numbers.substring(delimiterEnd + 1);
        }

        return numbers.split(delimiter);
    }
}