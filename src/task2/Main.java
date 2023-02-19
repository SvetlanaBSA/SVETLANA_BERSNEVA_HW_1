package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Необходимо ввести n чисел с консоли.
        // Найти максимальное и минимальное число. Вывести их в консоль.
        // Найти самое короткое и самое длинное число.
        // Вывести найденные числа и их длину следующей строкой.

        //ввести n чисел с консоли
        boolean correctCountNumber = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какое кол-во чисел будем исследовать?");
        int countOfNumbers = scanner.nextInt();
        while (correctCountNumber == false){
            if (countOfNumbers>0) {
                correctCountNumber = true;
            } else {
                System.out.println("Введите число > 0");
                countOfNumbers = scanner.nextInt();
            }
        }
        int[] numbers = new int[countOfNumbers];
        for (int i=0; i<countOfNumbers; i++){
            System.out.print("Введите "+(i+1)+" число списка: ");
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        // Найти максимальное число.
        int max = numbers[0];
        for (int i=1; i<countOfNumbers; i++){
            if (numbers[i]>max){
                max = numbers[i];
            }
        }
        System.out.println("Максимальное число в списке: "+max);
        // Найти минимальное число.
        int min = numbers[0];
        for (int i=1; i<countOfNumbers; i++){
            if (numbers[i]<min){
                min = numbers[i];
            }
        }
        System.out.println("Минимальное число в списке: "+min);
        // Найти самое короткое и самое длинное число.
        // Вывести найденные числа и их длину следующей строкой.
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
        //найдем минимальную и максимальную длину числа
        int minLength = numberLength[0];
        int maxLength = numberLength[0];
        for (int i=1; i<countOfNumbers; i++){
            if (numberLength[i]<min){
                minLength = numberLength[i];
            }
            if (numberLength[i]>maxLength){
                maxLength = numberLength[i];
            }
        }
        if (minLength==maxLength){
            System.out.println("Все числа из списка с одинаковой длинной.");
            for (int i=0; i<countOfNumbers; i++){
                if (numberLength[i]==minLength){
                    System.out.println("Число "+numbers[i]+" с длинной "+numberLength[i]);
                }
            }
        } else {
            System.out.println("Числа из списка с минимальной длинной: ");
            for (int i=0; i<countOfNumbers; i++){
                if (numberLength[i]==minLength){
                    System.out.println("Число "+numbers[i]+" с длинной "+numberLength[i]);
                }
            }
            System.out.println("Числа из списка с максимальной длинной: ");
            for (int i=0; i<countOfNumbers; i++){
                if (numberLength[i]==maxLength){
                    System.out.println("Число "+numbers[i]+" с длинной "+numberLength[i]);
                }
            }
        }
    }
}
