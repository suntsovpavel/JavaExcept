import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*int[] array = new int []{1,2,3,4,5};
        int my_length = 5;
        System.out.println(task2(array, my_length, 4));
        */

        writeToFile()
    }
    /*public static int task1(int[] arr, int min_length){
        return (arr.length > min_length ? -1 : arr.length);
    }*/

    /*Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
    если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
    если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
    если вместо массива пришел null, метод вернет -3
    придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
    Напишите метод, в котором реализуйте взаимодействие с пользователем.
    То есть, этот метод запросит искомое число у пользователя, вызовет первый,
    обработает возвращенное значение и покажет читаемый результат пользователю.
    Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */
    public static int task2(int[] arr, int min_length, int value){
        if(arr == null) return -3;
        if(arr.length < min_length) return -2;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == value) return i;
        }
        return -2;
    }

    /*Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
    Необходимо посчитать и вернуть сумму элементов этого массива.
    При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
    (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
    Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
    */
    public static int task3(int[][] arr, int min_length, int value){
        int len_line = arr[0].length;
        if(arr.length != len_line)
            throw new RuntimeException("массив не квадратный");
        int sum = 0;
        for(int[] line : arr){
            if (line.length != len_line)
                throw new RuntimeException("массив не квадратный");
            for(int el : line){
                if (el == 1) {
                    sum += 1;
                }else if(el == 0)
                    throw new RuntimeException("Элемент отличен от 0 либо 1");
            }
        }
        return sum;
    }

    /*Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
    Метод должен пройтись по каждому элементу и проверить что он не равен null.
    А теперь реализуйте следующую логику:
    Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
    Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
    */
    public static List<Integer> task4(Integer[] arr){
        //возвращаем список индексов null
        List<Integer> nullIndexes = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if (arr[i] == null)
                nullIndexes.add(i);
        }
        return nullIndexes;
    }
    /*Запишите в файл следующие строки:
    Анна=4
    Елена=5
    Марина=6
    Владимир=?
    Константин=?
    Иван=4
    Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
    (либо HashMap, если студенты с ним знакомы).
    В отдельном методе нужно будет пройти по структуре данных,
    если сохранено значение ?, заменить его на соответствующее число.
    Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
    Записать в тот же файл данные с замененными символами ?.
    */
    public static List<String[]> readToArray(String path){
        List<String[]> strings = new ArrayList<>();
        try{
            FileReader reader = new FileReader(path);
            BufferedReader bufReader = new BufferedReader(reader);

            String line;
            while((line = bufReader.readLine()) != null){
                strings.add(line.split("="));
            }
            /*for(String[] s : strings){
                System.out.println(String.join(" ", s));
            }*/
        }
        catch (IOException e){
            System.out.println("Ошибка доступа к файлу " + path);
        }
        return strings;
    }

    public static boolean isNumerical(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static void change(List<String[]> strings){
        for(String[] s : strings){
            if(!s[1].equals("?") && !isNumerical(s[1])){
                throw new RuntimeException("Не число");
            }
            else if(s[1].equals("?")){
                s[1] = Integer.toString(s[0].length());
            }
        }
    }

    public static boolean writeToFile(List<String[]> strings, String path){

    }

}
