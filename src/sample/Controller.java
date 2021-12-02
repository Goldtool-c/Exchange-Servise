package sample;

import application.storage.PersonStorage;
import application.util.UserNameField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.action.admin.ShowBalance;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label userNameLabel;

    @FXML
    private Button logOutButton;

    @FXML
    private ComboBox<String> yourCurBox;

    @FXML
    private ComboBox<String> bankCurBox;

    @FXML
    private TextField userCurrencyField;

    @FXML
    private Label userBalanceLabel;

    @FXML
    private Label bankBalanceLabel;

    @FXML
    private Label userCurExchangeLabel;

    @FXML
    private TextField bankCurrencyField1;

    @FXML
    private Label bankCurExchangeLabel1;

    @FXML
    private Button exchangeButton;

    @FXML
    private Label historyLabel;

    @FXML
    private TextField historyFromField;

    @FXML
    private TextField historyToField;

    @FXML
    private Label toLabel;

    @FXML
    private Button getHistoryButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserNameField.customerLabel=userNameLabel;
        yourCurBox.getItems().add("Rubble");
        yourCurBox.getItems().add("Dollar");
        yourCurBox.getItems().add("Yuan");
        bankCurBox.getItems().add("Rubble");
        bankCurBox.getItems().add("Dollar");
        bankCurBox.getItems().add("Yuan");
        yourCurBox.setOnAction(event -> ShowBalance.show(yourCurBox, userBalanceLabel));
    }
}
