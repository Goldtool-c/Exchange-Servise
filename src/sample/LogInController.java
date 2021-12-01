package sample;

import application.logIn.LogIn;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button logInButton;
    @Override
    public void initialize(URL Ur1, ResourceBundle rb)
    {
        logInButton.setOnAction(event ->
        {
            LogIn.logIn(logInButton);
        });
    }
}
