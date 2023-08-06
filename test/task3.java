//Разработайте программу, которая выбросит Exception,
// когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
// 3. Метод бросает исключение, оно не перхватывается, а main бросает его выше

import java.util.Scanner;
public class task3 {
    public static void main(String[] args) throws Exception {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf(messageHandler(iScanner));                  
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