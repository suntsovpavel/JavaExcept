package workWithUser;

import static java.lang.Integer.parseInt;

//Этот класс содержит данные, введенные пользователем
public class DataHuman {
    //модификатор доступа package, чтобы с данными мог работать класс WorkWithUser
    String fio; //фамилия-имя-отчество, разделенные пробелом
    String surname;     //фамилия отдельно. Понадобится при обращении к файлу
    String phone;  //номер телефона
    String dateBirth; //дата рождения в формате dd.mm.yyyy
    String sex; //пол: f либо m

    //Метод кидает исключение  MissingDataException, если какие-либо данные отсутствуют
    public void checkData() throws MissingDataException {
        if(fio != null
                && surname != null
                && phone != null
                && dateBirth != null
                && sex != null) return;  //все ок

        StringBuilder message = new StringBuilder();
        message.append("Недостающие данные:");
        if(fio == null) message.append("\n- фамилия-имя-отчество");
        if(phone == null) message.append("\n- номер телефона");
        if(dateBirth == null) message.append("\n- дата рождения");
        if(sex == null) message.append("\n- пол");
        throw new MissingDataException(message.toString());
    }

    public String getSurname() throws MissingDataException {
        checkData();
        return surname;
    }

    //данные одной строкой для записи в файл
    public String getInfo() throws MissingDataException {
        checkData();
        return fio + " "
                + dateBirth + " "
                + phone + " "
                + sex;
    }
}
