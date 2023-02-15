package Task1;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        //•	Ввести число от 1 до 7.
        // Вывести на консоль название дня недели, соответствующего данному числу.
        // Осуществить проверку корректности ввода. (1 балл)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введтте число от 1 до 7: ");
        try {
            int numberOfDay = scanner.nextInt();
            scanner.close();
            switch (numberOfDay) {
                case 1:
                    System.out.print("Понедельник");
                    break;
                case 2:
                    System.out.print("Вторник");
                    break;
                case 3:
                    System.out.print("Среда");
                    break;
                case 4:
                    System.out.print("Четверг");
                    break;
                case 5:
                    System.out.print("Пятница");
                    break;
                case 6:
                    System.out.print("Суббота");
                    break;
                case 7:
                    System.out.print("Воскресение");
                    break;
                default:
                    System.out.println("Нет такого дня недели");
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Вы ввели НЕ число");
        }
    }
}
