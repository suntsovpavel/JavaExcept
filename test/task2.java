//Разработайте программу, которая выбросит Exception,
// когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
// 2. Метод бросает исключение и сам же его перехватывает

import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        messageHandler();                
    }

    public static void messageHandler() {        
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите строку: ");        
        try{
            String str = iScanner.nextLine();
            if(str.length() == 0){
                throw new Exception("!!! Пустые строки вводить нельзя !!!");
            }
            System.out.printf("Введена строка: " + str);
        }
        catch (Exception e){            
            System.out.println(e);  // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        }finally{
            iScanner.close();
        }            
    }    
}