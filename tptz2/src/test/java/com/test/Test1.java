package com.test;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test1 {

    private ArrayList<Long> numbers;

    @BeforeAll
    public void setup() throws Exception {
        numbers = App.readNumbersFromFile("test_num.txt");
    }

    @Test
    public void testMinimum() throws IOException {
        assertEquals(Long.valueOf("12"), App.getMinimum(numbers));
        System.out.println("Минимальный тест успешно пройден");
    }

    @Test
    public void testMaximum() throws IOException {
        assertEquals(Long.valueOf("97"), App.getMaximum(numbers));
        System.out.println("Максимальный тест успешно пройден");
    }

    @Test
    public void testSumma() throws IOException {
        assertEquals(String.valueOf("536"), App.getSumma(numbers));
        System.out.println("Тест суммы успешно пройден");
    }

    @Test
    public void testMultiplication() throws IOException {
        assertEquals("42202794854505600", App.getMultiplication(numbers));
        System.out.println("Тест умножения успешно пройден");
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

    @Test
    public void testMultiplicationPerformance() {
        int[] sizes = {100, 10000, 100000, 500000, 1000000};
        for (int size : sizes) {
            ArrayList<Long> numbers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                numbers.add((long)(Math.random() * 1000));
            }
            long startTime = System.nanoTime();
            App.getMultiplication(numbers);
            long endTime = System.nanoTime();
            long durationMultiplication = (endTime - startTime) / 1000000;
            startTime = System.nanoTime();
            App.getSumma(numbers);
            endTime = System.nanoTime();
            long durationSum = (endTime - startTime) / 1000000;
            System.out.println("Размер: " + size + ", Время умножения: " + durationMultiplication + " мс; Время суммы: " + durationSum + " мс");
        }
    }
}
