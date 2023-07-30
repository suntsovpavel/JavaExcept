import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        class Answer {
            public static void arrayOutOfBoundsException() {
                // Напишите свое решение ниже
                List<Integer> arr = new ArrayList<>();
                int result = arr.get(0);
            }

            public static void divisionByZero() {
                // Напишите свое решение ниже
                int a = 1, b = 0;
                int result = a / b;
            }

            public static void numberFormatException() {
                // Напишите свое решение ниже
                int result = Integer.parseInt("some string");
            }
        }

        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}