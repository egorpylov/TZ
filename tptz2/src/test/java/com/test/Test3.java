package com.test;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test3 {
    private ArrayList<Long> numbers;

    @BeforeAll
    public void initialize() throws Exception {
        numbers = App.readNumbersFromFile("test_num.txt");
    }

    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testMinimum() {
        assertEquals(Long.valueOf(12), App.getMinimum(numbers));
    }

    @Test
    public void testMaximum() {
        assertEquals(Long.valueOf(97), App.getMaximum(numbers));
    }

    @Test
    public void testSumCalculation() {
        assertEquals(String.valueOf(536), App.getSumma(numbers));
    }

    @Test
    public void testMultiplication() {
        assertEquals("42202794854505600", App.getMultiplication(numbers));
    }

    @Disabled
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeoutFailure() {
        ArrayList<Long> largeNumbers = new ArrayList<>();
        for (long i = 1; i <= 100000; i++) {
            largeNumbers.add(i);
        }
        App.getMultiplication(largeNumbers);
    }
}
