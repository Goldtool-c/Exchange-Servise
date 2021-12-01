package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label userNameLabel;

    @FXML
    private Button logOutButton;

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

}
