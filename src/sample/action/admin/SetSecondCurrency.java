package sample.action.admin;


import application.bank.Bank;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.HashMap;
/**
 * Класс выполняет задачу задания значения объема валюты для обмена в userCurrencyField на основе данных в bankCurrencyField1
 * или наоборот
 * @author Денис Гладышев
 * @version 1.0*/
public class SetSecondCurrency {
    /**
     * Метод задает значение второго CurrencyField
     * @param second - поле, которое необходимо заполнить на основе данных из first
     * @param first - поле с данными об объеме обмена со стороны участника 1
     * @param firstBox - тип валюты участника 1
     * @param secondBox - тип валюты участника 2*/
    public static void set(TextField first, TextField second, ComboBox<String> firstBox, ComboBox<String> secondBox)
    {
        //для покупки банком
        double firstNumber = Double.parseDouble(first.getText());
        String firstCurrency = firstBox.getValue();
        String secondCurrency = secondBox.getValue();
        HashMap<String, Double> rate = Bank.GENERAL.getExchangeRate();
        double firstRate = rate.get(firstCurrency);
        double secondRate = rate.get(secondCurrency)+(0.02*rate.get(secondCurrency));
        double secondNumber = (firstRate/secondRate)*firstNumber;
        second.setPromptText(""+secondNumber);
    }
}
