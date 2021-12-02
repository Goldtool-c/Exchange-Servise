package sample.action.admin;

import application.bank.Bank;
import application.storage.PersonStorage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class Exchange {
    public static void exchange(TextField userValue, TextField bankValue, ComboBox<String> userCurrency, ComboBox<String> bankCurrency)
    {
        String userValueStr;
        String bankValueStr;
        String userCurrencyStr = parseCurrency(userCurrency);
        String bankCurrencyStr = parseCurrency(bankCurrency);
        if(isFill(userValue, bankValue))
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
            //delete next
            System.out.println("bank: " + Bank.GENERAL.getVault());
            System.out.println("user: " + PersonStorage.GENERAL.getUser().getBalance());
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
}
