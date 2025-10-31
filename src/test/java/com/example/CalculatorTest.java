package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void shouldReturnZeroForEmptyString(){
        assertEquals(0,Calculator.add(""));
    }

    @Test
    public void shouldReturnNumberForSingleNumber(){
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void shouldReturnSumOfTwoNumbersDelimitedByComma(){
        assertEquals(3, Calculator.add("1,2"));
    }
}
