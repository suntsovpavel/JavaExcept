//Разработайте программу, которая выбросит Exception,
// когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
// 1. Метод бросает исключение, а main его перехватывает

import java.util.Scanner;
public class task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        try{
            String result = messageHandler(iScanner);
            System.out.printf(result.length() == 0 ? "Введена пустая строка" : ("Введена строка: " + result));
        }
        catch (Exception e){
            System.out.println(e);  // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        }            
        iScanner.close();
    }

    public static String messageHandler(Scanner iScanner) throws Exception {        
        System.out.printf("Введите строку: ");
        String str = iScanner.nextLine();
        if(str.length() == 0){
            throw new Exception("!!! Пустые строки вводить нельзя !!!");
        }
        return str;
    }    
}