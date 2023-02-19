package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Необходимо ввести n чисел с консоли.
        // Найти максимальное и минимальное число. Вывести их в консоль.
        // Найти самое короткое и самое длинное число.
        // Вывести найденные числа и их длину следующей строкой.

        int[] numbers;
        try {
            //ввести n чисел с консоли
            numbers = scanNumbers();

            // Найти максимальное число.
            searchMaxNumber(numbers);
            // Найти минимальное число.
            searchMinNumber(numbers);

            // Найти самое короткое и самое длинное число.
            // Вывести найденные числа и их длину следующей строкой.
            searchMinMaxLengthNumbers(numbers);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы ввели число = 0. Длинна массива не может быть <= 0");
        } catch (NegativeArraySizeException e) {
            System.out.println("Вы ввели число < 0. Длинна массива не может быть <= 0");
        }
    }

    private static int[] scanNumbers() {
        int countOfNumbers = getCountOfNumbers();
        int[] numbers = new int[countOfNumbers];
        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<countOfNumbers; i++){
            System.out.print("Введите "+(i+1)+" число списка: ");
            if (scanner.hasNextInt()){
                numbers[i] = scanner.nextInt();
            } else {
                System.out.println("Вы ввели НЕ целое число. Длинна массива не божет быть десятичным числом");
                break;
            }
        }
        scanner.close();
        return numbers;
    }

    private static int getCountOfNumbers() {
        int countOfNumbers = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какое кол-во чисел будем исследовать?");
        if (scanner.hasNextInt()){
            countOfNumbers = scanner.nextInt();
        } else {
            System.out.println("Вы ввели НЕ целое число");
        }
        return countOfNumbers;
    }

    private static void searchMaxNumber(int[] numbers) {
        int max = numbers[0];
        int countOfNumbers = numbers.length;

        for (int i=1; i<countOfNumbers; i++){
            if (numbers[i]>max){
                max = numbers[i];
            }
        }
        System.out.println("Максимальное число в списке: "+max);
    }

    private static void searchMinNumber(int[] numbers) {
        int min = numbers[0];
        int countOfNumbers = numbers.length;

        for (int i=1; i<countOfNumbers; i++){
            if (numbers[i]<min){
                min = numbers[i];
            }
        }
        System.out.println("Минимальное число в списке: "+min);
    }

    private static void searchMinMaxLengthNumbers(int[] numbers) {
        //создадим массив длин каждого числа в массиве numbers
        int[] numberLength = getNumbersLength(numbers);

        //найдем минимальную и максимальную длину числа
        int minLength = findMinLength(numberLength);
        int maxLength = findMaxLength(numberLength);

        printNumbersWithMinMaxLength(numbers, numberLength, minLength, maxLength);
    }

    private static int[] getNumbersLength(int[] numbers) {
        int countOfNumbers = numbers.length;
        int[] numberLength = new int[countOfNumbers];

        for (int i=0; i<countOfNumbers; i++){
            int number = numbers[i];
            int lenght = 1;
            while ((number>9) || (number<-9)){
                number /= 10;
                lenght++;
            }
            numberLength[i] = lenght;
        }
        return numberLength;
    }

    private static int findMinLength(int[] numberLength) {
        int countOfNumbers = numberLength.length;
        int minLength = numberLength[0];

        for (int i=1; i<countOfNumbers; i++){
            if (numberLength[i]<minLength){
                minLength = numberLength[i];
            }
        }
        return minLength;
    }

    private static int findMaxLength(int[] numberLength) {
        int countOfNumbers = numberLength.length;
        int maxLength = numberLength[0];

        for (int i=1; i<countOfNumbers; i++){
            if (numberLength[i]>maxLength){
                maxLength = numberLength[i];
            }
        }
        return maxLength;
    }

    private static void printNumbersWithMinMaxLength(int[] numbers, int[] numberLength, int minLength, int maxLength) {
        if (minLength==maxLength){
            System.out.println("Все числа из списка с одинаковой длинной.");
            printNumbersWithParticularLength(numbers, numberLength, minLength);
        } else {
            System.out.println("Числа из списка с минимальной длинной: ");
            printNumbersWithParticularLength(numbers, numberLength, minLength);

            System.out.println("Числа из списка с максимальной длинной: ");
            printNumbersWithParticularLength(numbers, numberLength, maxLength);
        }
    }

    private static void printNumbersWithParticularLength(int[] numbers, int[] numberLength, int length) {
        int countOfNumbers = numbers.length;
        for (int i=0; i<countOfNumbers; i++){
            if (numberLength[i]==length){
                System.out.println("Число "+numbers[i]+" с длинной "+numberLength[i]);
            }
        }
    }
}
