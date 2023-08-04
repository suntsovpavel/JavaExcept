import workWithUser.DataHuman;
import workWithUser.MissingDataException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFiles {
    public String writeToFile(DataHuman dataHuman) throws IOException, MyExceptionDuplicateData, MissingDataException {
        String path = dataHuman.getSurname() + ".txt";
        //Проверяем наличие файла
        File f = new File(path);
        if(f.exists()){
            //Файл найден. Считываем данные, чтобы убедиться, что вновь добавляемая строка уникальна
            FileReader fr = new FileReader(f);
            BufferedReader reader = new BufferedReader(fr);
            List<String> lines = new ArrayList<>();

            //Считываем содержимое файла в набор строк
            while (true) {  //выход через break
                String line = reader.readLine();
                if(line == null) break;
                lines.add(line);
            }
            reader.close();
            fr.close();

            //Проверяем, что вновь добавляемая строка данных уникальна:
            //Если не уникальна, бросаем MyExceptionDuplicateData
            for(String s : lines){
                if(s.equals(dataHuman.getInfo()))
                    throw new MyExceptionDuplicateData(path, dataHuman.getInfo());
            }

            //Добавляем строку и перезаписываем файл
            lines.add(dataHuman.getInfo());
            FileWriter fw = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(fw);
            for(String s : lines) {
                writer.write(s + '\n');
            }
            writer.close();
            fw.close();
            return "Файл " + path + " успешно перезаписан";
        }else{
            //Создаем файл и записываем в него строку
            FileWriter fw = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(dataHuman.getInfo());
            writer.close();
            fw.close();
            return "Файл " + path + " создан";
        }
    }
}
