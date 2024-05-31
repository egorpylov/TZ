package com.test;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public class Test2 {
    @Test
    public void testMultPerformance() {
        int[] sizes = {100, 10000, 100000, 500000, 1000000};
        for (int size : sizes) {
            ArrayList<Long> numbers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                numbers.add((long)(Math.random() * 1000));
            }
            long startTime = System.nanoTime();
            App.getMultiplication(numbers);
            long endTime = System.nanoTime();
            long duration_multiplication = (endTime - startTime)/1000000;
            startTime = System.nanoTime();
            App.getSumma(numbers);
            endTime = System.nanoTime();
            long duration_sum = (endTime - startTime)/1000000;
            System.out.println("Size: " + size + ", Time_mult: " + duration_multiplication + " ms; Time_sum: " + duration_sum + " ms" );
        }

    }
}