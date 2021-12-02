package sample.action.admin;


import application.bank.Bank;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class SetSecondCurrency {
    public static void set(TextField first, TextField second, ComboBox<String> firstBox, ComboBox<String> secondBox)
    {
        double firstNumber = Double.parseDouble(first.getText());
        String firstCurrency = firstBox.getValue();
        String secondCurrency = secondBox.getValue();
        HashMap<String, Double> rate = Bank.GENERAL.getExchangeRate();
        double firstRate = rate.get(firstCurrency);
        double secondRate = rate.get(secondCurrency);
        double secondNumber = (firstRate/secondRate)*firstNumber;
        second.setPromptText(""+secondNumber);
    }
}
