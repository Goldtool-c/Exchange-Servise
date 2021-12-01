package application.logIn;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogIn {
    public static void logIn(Button logInButton)
    {
        Stage stage = (Stage)logInButton.getScene().getWindow();
        stage.close();
    }
}
