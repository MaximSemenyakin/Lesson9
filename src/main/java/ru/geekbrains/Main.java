package ru.geekbrains;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    private static int myArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length != 4 || arr[i].length != 4) {
                    throw new MyArraySizeException("Массив неверного размера, задайте его размером [4][4]");
                } try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Массив содержит неверный формат в " + i + " " + j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        String[][] str = new String[4][4];

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                str[i][j] = String.valueOf(random.nextInt(30));
            }
        }

        String[][] array = {{"1", "4", "8", "9"}, {"2", "r", "10", "5"}, {"4", "12", "23", "5"}, {"5", "8", "7", "46"}};

        try {
            int result = myArray(array);
            System.out.println("Результат массива array: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int result1 = myArray(str);
            System.out.println("Результат массива str: " + result1);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }


    }
}
