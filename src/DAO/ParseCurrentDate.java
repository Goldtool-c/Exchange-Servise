package DAO;

import application.bank.Bank;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ParseCurrentDate {
    public static void parse()
    {
        try(FileWriter writer = new FileWriter("./src/dataBase/currentDate.txt", false))
        {
            // запись всей строки
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            String text = format.format(Bank.GENERAL.getCurrentDate());
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
