public class MyExceptionDuplicateData extends RuntimeException{
    MyExceptionDuplicateData(String path, String dataHuman){
        super("Файл '" + path + "' уже содержит в себе данные '" + dataHuman);
    }
}
