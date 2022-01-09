package sample.action.admin;

import application.bank.Bank;
import application.storage.PersonStorage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * Класс выполняет задачу отображения информации о объеме нужной валюты в хранилище банка
 * @author Денис Гладышев
 * @version 1.0*/
public class ShowBankBalance {
    /**
     * @param box - тип валюты
     * @param label - лебл для отображения баланса*/
    public static void show(ComboBox<String> box, Label label)
    {
        String value = box.getValue();
        System.out.println(value);
        switch (value) {
            case "Rubble": {
                label.setText("Balance: " + Bank.GENERAL.getVault().get("RUBBLE").toString());
                break;
            }
            case "Dollar": {
                label.setText("Balance: " + Bank.GENERAL.getVault().get("DOLLAR").toString());
                break;
            }
            case "Yuan": {
                label.setText("Balance: " + Bank.GENERAL.getVault().get("YUAN").toString());
            }
            default: {
                break;
            }
        }
    }
}
