package com.test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
public class App {

    public static long getMinimum(ArrayList<Long> numbers) {
        long minimum = numbers.get(0);

        return minimum;
    }

    public static long getMaximum(ArrayList<Long> numbers) {
        long maximum = numbers.get(0);
        for (Long number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }

    public static String getSumma(ArrayList<Long> numbers) {
        BigInteger sum = new BigInteger("0");
        for (Long number : numbers) {
            sum = sum.add(BigInteger.valueOf(number));
        }
        return String.valueOf(sum);
    }

    public static String getMultiplication(ArrayList<Long> numbers) {
        BigInteger multiplication = new BigInteger("1");
        for (Long number : numbers) {
            multiplication = multiplication.multiply(BigInteger.valueOf(number));
        }
        return String.valueOf(multiplication);
    }
    public static ArrayList<Long> readNumbersFromFile(String filename) throws IOException {
        ArrayList<Long> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] nums = line.split(" ");
            for (String num : nums) {
                numbers.add(Long.parseLong(num));

            }
        }
        return numbers;
    }


    public static void main(String[] args) throws IOException {

        ArrayList<Long> numbers = readNumbersFromFile("test_num.txt");
        System.out.println("Минимум: " + getMinimum(numbers));
        System.out.println("Максимум: " + getMaximum(numbers));
        System.out.println("Сумма: " + getSumma(numbers));
        System.out.println("Произведение: " + getMultiplication(numbers));
    }
}