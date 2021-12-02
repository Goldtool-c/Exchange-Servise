package sample.action.admin;

import application.bank.Bank;
import application.storage.PersonStorage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ShowBankBalance {
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
