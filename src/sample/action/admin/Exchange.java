package sample.action.admin;

import DAO.ParseEntity;
import application.bank.Bank;
import application.entity.CheckFactory;
import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;
import application.storage.CheckStorage;
import application.storage.PersonStorage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

public class Exchange {
    public static void exchange(TextField userValue, TextField bankValue, ComboBox<String> userCurrency, ComboBox<String> bankCurrency) throws UnknownRoleException, ParseException, UnknownCurrencyException {
        String userValueStr;
        String bankValueStr;
        String userCurrencyStr = parseCurrency(userCurrency);
        String bankCurrencyStr = parseCurrency(bankCurrency);
        if(valid(userValue, bankValue, userCurrencyStr, bankCurrencyStr))
        {
            userValueStr = parseValue(userValue);
            bankValueStr = parseValue(bankValue);
            HashMap<String, Double> vault = Bank.GENERAL.getVault();
            //текущие значения
            double bankGive = vault.get(bankCurrencyStr);
            double bankGet = vault.get(userCurrencyStr);
            double userGet = Double.parseDouble(PersonStorage.GENERAL.getUser().getBalance().get(bankCurrencyStr).toString());
            double userGive = Double.parseDouble(PersonStorage.GENERAL.getUser().getBalance().get(userCurrencyStr).toString());
            vault.put(bankCurrencyStr, bankGive - Double.parseDouble(bankValueStr));
            vault.put(userCurrencyStr, bankGet + Double.parseDouble(userValueStr));
            PersonStorage.GENERAL.getUser().getBalance().put(userCurrencyStr, userGive - Double.parseDouble(userValueStr));
            PersonStorage.GENERAL.getUser().getBalance().put(bankCurrencyStr, userGet + Double.parseDouble(bankValueStr));
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            String date = format.format(Bank.GENERAL.getCurrentDate());
            CheckFactory.GENERAL.create(true, date, "cashier1", PersonStorage.GENERAL.getUser().getName(),
                    userCurrencyStr, bankCurrencyStr, userValueStr, bankValueStr);
            ParseEntity.parse(CheckStorage.GENERAL, "Check");
            ParseEntity.parse(PersonStorage.GENERAL, "Person");
            //"date","cashierName", "customerName", "customerCurrency","bankCurrency", "customerCurrencyValue","bankCurrencyValue","id"
        }
    }
    private static boolean isFill(TextField userValue, TextField bankValue)
    {
        if(userValue.getText().equals("") && userValue.getPromptText().equals(""))
        {
            System.out.println("false user");
            return false;
        }
        if(bankValue.getPromptText().equals("") && bankValue.getText().equals(""))
        {
            System.out.println("false bank");
            return false;
        }
        if(!userValue.getText().equals("") && !bankValue.getText().equals(""))
        {
            System.out.println("one of the fields should have prompt");
            return false;
        }
        return true;
    }
    private static String parseCurrency(ComboBox<String> currency)
    {
        switch (currency.getValue())
        {
            case "Rubble":
            {
                return "RUBBLE";
            }
            case "Dollar":
            {
                return "DOLLAR";
            }
            case "Yuan":
            {
                return "YUAN";
            }
            default:
            {
                return "YUAN1";
            }
        }
    }
    private static String parseValue(TextField value)
    {
        if(!value.getText().equals("")) {
            return value.getText();
        }
        else {
            return value.getPromptText();
        }
    }
    private static void printCheck()
    {

    }
    private static boolean valid(TextField userValue, TextField bankValue, String userCurrencyStr, String bankCurrencyStr)
    {
        double userBalance, bankBalance;
        if(!isFill(userValue, bankValue))
        {
            System.out.println("invalid data in textFields");
            return false;
        }
        if(!userValue.getText().equals(""))
        {
            userBalance=Double.parseDouble(userValue.getText());
        } else {
            userBalance = Double.parseDouble(userValue.getPromptText());
        }
        if(!bankValue.getText().equals(""))
        {
            bankBalance=Double.parseDouble(bankValue.getText());
        } else {
            bankBalance = Double.parseDouble(bankValue.getPromptText());
        }
        if(bankBalance>Bank.GENERAL.getVault().get(bankCurrencyStr)||userBalance>(double)PersonStorage.GENERAL.getUser().getBalance().get(userCurrencyStr))
        {
            System.out.println("User or bank does not have enough currency for this operation");
            return false;
        }
        return true;
    }
}
