package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import sample.action.logIn.LogIn;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * Класс контроллер для окна, заданного файлом LogInSample.fxml
 * @author Денис Гладышев
 * @version 1.0*/
public class LogInController implements Initializable {
    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button logInButton;

    private String login;
    private String password;
    @Override
    public void initialize(URL Ur1, ResourceBundle rb)
    {
        loginField.textProperty().addListener((observable, oldValue, newValue) -> login = newValue);
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> password = newValue);
        logInButton.setOnAction(event ->
        {
            LogIn.logIn(logInButton, login, password);
        });
    }
}
