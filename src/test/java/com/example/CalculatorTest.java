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

    @Test
    public void shouldReturnSumOfMultipleNumbersDelimitedByComma(){
        assertEquals(10,Calculator.add("1,2,5,1,1"));
    }

    @Test
    public void shouldAcceptNewLineAsValidDelimiter(){
        assertEquals(6, Calculator.add("1\n2,3"));
    }
    @Test
    public void shouldAcceptCustomDelimiter(){
        assertEquals(7, Calculator.add("//;\n1;2;4"));
    }
    @Test
    public void customDelimiterCouldBeAlsoASpecialRegexChar(){
        assertEquals(9,Calculator.add("//.\n1.2.4.2"));
    }
    @Test
    public void shouldRaiseExceptionOnNegativeNumbers(){
        try{
            Calculator.add("1,-2");
            fail("Exception expected");
        }catch(RuntimeException ex){
            assertEquals(ex.getMessage(),"negatives not allowed -2");
        }
    }
    @Test
    public void shouldRaiseExceptionOnNegativeNumbersWithAllNegativeNumbersInExceptionMessage(){
        try{
            Calculator.add("1,-2,-3");
            fail("Exception expected");
        }catch(RuntimeException ex){
            assertEquals(ex.getMessage(), "negatives not allowed -2, -3");
        }
    }
    @Test
    public void numbersBiggerThan1000ShouldBeIgnored(){
        assertEquals(2, Calculator.add("2,1001"));
    }
    @Test
    public void shouldAcceptCustomDelimiterOfAnyLengthWithStartingPattern(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }
    @Test
    public void shouldAcceptMultipleCustomDelimiters(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }
    @Test
    public void shouldAcceptMultipleCustomDelimitersWithLengthLongerThanOneChar(){
        assertEquals(6, Calculator.add("//[**][%%]\n1**2%%3"));
    }
}
