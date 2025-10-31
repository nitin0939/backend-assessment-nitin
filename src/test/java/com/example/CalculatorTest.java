package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void shouldReturnZeroForEmptyString(){
        assertEquals(0,Calculator.add(""));
    }
}
