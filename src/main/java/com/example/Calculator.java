package com.example;

public class Calculator {
    public static int add(String numbers) {
        if(numbers.isEmpty())
            return 0;
        else if (numbers.contains(",")) {
            String tokens[] = numbers.split(",|\n");
            int sum = 0;
            for(String token:tokens){
                sum += Integer.parseInt(token);
            }
            return sum;
        }
        return Integer.parseInt(numbers);
    }
}
