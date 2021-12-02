package DAO;

import application.bank.Bank;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
