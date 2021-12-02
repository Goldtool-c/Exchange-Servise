package sample.action.admin;

import application.storage.PersonStorage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ShowBalance {
    public static void show(ComboBox<String> box, Label label)
    {
        String value = box.getValue();
        System.out.println(value);
        switch (value)
        {
            case "Rubble":
            {
                label.setText("Balance: "+PersonStorage.GENERAL.getUser().getBalance().get("RUBLE").toString());
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
