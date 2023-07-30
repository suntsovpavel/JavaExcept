/**
 * task1
 */
import java.util.Scanner;

//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.
public class task1 {

    public static void main(String[] args) {
        System.out.printf(String.format("Введено число %f", getNumberFloat()));
    }
    public static float getNumberFloat(){
        Scanner iScanner = new Scanner(System.in);
        float result=0;
        while(true){    //выход оператором return
            try {
                System.out.printf("Введите число тип double: ");
                result = Float.parseFloat(iScanner.nextLine());
                iScanner.close();
                return result;
            }
            catch(NumberFormatException e) {
                System.out.printf("Неверный формат числа, пожалуйста, повторите ввод\n");
            }
        }
    }
}