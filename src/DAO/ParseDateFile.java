package DAO;

import application.bank.Bank;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Класс преобразователь. Читает дату из файла и заносит в {@link Bank}
 * @author Денис Гладышев
 * @version 1.0*/
public class ParseDateFile {
    public static void parse()
    {
        String date;
        StringBuilder sb = new StringBuilder();
        try(FileReader reader = new FileReader("./src/dataBase/currentDate.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                sb.append((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        date = sb.toString();
        Bank.GENERAL.setDate(date);
    }
}
