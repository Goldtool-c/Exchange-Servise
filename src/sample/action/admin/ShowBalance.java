package sample.action.admin;

import application.storage.PersonStorage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * Класс выполняет задачу отображения информации о балансе клиента
 * @author Денис Гладышев
 * @version 1.0*/
public class ShowBalance {
    /**
     * @param box - тип валюты
     * @param label - лебл для отображения баланса*/
    public static void show(ComboBox<String> box, Label label)
    {
        String value = box.getValue();
        System.out.println(value);
        switch (value)
        {
            case "Rubble":
            {
                label.setText("Balance: "+PersonStorage.GENERAL.getUser().getBalance().get("RUBBLE").toString());
                break;
            }
            case "Dollar":
            {
                label.setText("Balance: "+PersonStorage.GENERAL.getUser().getBalance().get("DOLLAR").toString());
                break;
            }
            case "Yuan":
            {
                label.setText("Balance: "+PersonStorage.GENERAL.getUser().getBalance().get("YUAN").toString());
            }
            default:
            {
                break;
            }
        }
    }
}
