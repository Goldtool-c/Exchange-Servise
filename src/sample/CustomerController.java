package sample;

import application.exception.InValidDateException;
import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;
import application.util.UserNameField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.action.admin.*;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
/**
 * Класс контроллер для окна, заданного файлом CustomerSample.fxml
 * @author Денис Гладышев
 * @version 1.0*/
public class CustomerController implements Initializable {
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

    private String userCurrencyExchange;
    private String bankCurrencyExchange;
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
        bankCurBox.setOnAction(event -> ShowBankBalance.show(bankCurBox, bankBalanceLabel));
        userCurrencyField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            userCurrencyExchange = newValue;
            SetSecondCurrency.set(userCurrencyField, bankCurrencyField1, yourCurBox, bankCurBox);
        });
        bankCurrencyField1.textProperty().addListener((observable, oldValue, newValue) ->
        {
            bankCurrencyExchange = newValue;
            SetSecondCurrency.set(bankCurrencyField1, userCurrencyField, bankCurBox, yourCurBox);
        });
        exchangeButton.setOnAction( event -> {
            try {
                Exchange.exchange(userCurrencyField, bankCurrencyField1, yourCurBox, bankCurBox);
            } catch (UnknownRoleException | ParseException | UnknownCurrencyException e) {
                e.printStackTrace();
            }
            ShowBalance.show(yourCurBox, userBalanceLabel);
            ShowBankBalance.show(bankCurBox, bankBalanceLabel);
        });
        logOutButton.setOnAction(event -> LogOut.logOut(logOutButton));
    }
}
