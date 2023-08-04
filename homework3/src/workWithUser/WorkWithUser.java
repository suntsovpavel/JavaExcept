package workWithUser;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class WorkWithUser {
    private String surname;
    public DataHuman getData() {
        System.out.println("Введите в произвольном порядке следующие данные:");
        System.out.println("- фамилия-имя-отчество через пробелы");
        System.out.println("- дату рождения в формате dd.mm.yyyy");
        System.out.println("- номер телефона");
        System.out.println("- пол (f либо m)");
        Scanner iScanner = new Scanner(System.in);
        DataHuman data = new DataHuman();
        for (int i = 0; i < 4; i++) {       //обрабатываем 4 строки
            String messageUser = iScanner.nextLine();
            //System.out.println("'" + messageUser + "'");
            if (data.fio == null && checkFIO(messageUser)) {
                data.fio = messageUser;
                data.surname = surname;
                System.out.println("ФИО корректно введено");
                continue;
            }
            if (data.phone == null && checkPhone(messageUser)) {   //значение по умолчанию
                data.phone = messageUser;
                System.out.println("Номер телефона корректно введен");
                continue;
            }
            if (data.dateBirth == null && checkDateBirth(messageUser)) {
                data.dateBirth = messageUser;
                System.out.println("Дата рождения корректно введена");
                continue;
            }
            if (data.sex == null && (messageUser.equals("f") || messageUser.equals("m"))) {
                data.sex = messageUser;
                System.out.println("Пол корректно введен");
            }
        }
        iScanner.close();
        return data;
    }

    //проверяем, соответствует ли введенная строка фамилии-имени-отчеству
    private boolean checkFIO(String str) {
        String[] splitted = str.split(" ");
        if (splitted.length != 3)
            return false;
        //Проверяем, что каждый сплит включает в себя только буквы
        for (String el : splitted) {
            if(!isAlpha(el)) return false;
        }
        surname = splitted[0];  //в питоне можно было бы вернуть кортеж (flag, surname)
        return true;
    }

    //Содержит ли строка только буквы
    private boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    //Проверяем корректность введенного номера телефона
    private boolean checkPhone(String str) {
        //считаем, что номер телефона содержит от 4 до 10 цифр
        if(str.length() < 4 || str.length() > 10) return false;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    //проверяем, соответствует ли введенная строка дате рождения в формате dd.mm.yyyy
    private boolean checkDateBirth(String str){
        String[] splitted = str.split("\\.");
        if (splitted.length != 3)
            return false;
        for (int i=0; i<splitted.length; i++){
            try{
                int number = parseInt(splitted[i]);
                if(i==0){
                    //число месяца. Делаем простую проверку от 1 до 31
                    // (по-хорошему надо с учетом 30 марта-мая- и т.д., а также 28 февраля в високосном году...)
                    if(number<1 || number> 31) return false;
                }else if(i==1){
                    //месяц
                    if(number<1 || number> 12) return false;
                }else{
                    //год
                    if(number<1900 || number> 2023) return false;
                }
            }catch (NumberFormatException e){
                return false;
            }
        }
        return true;
    }
}
