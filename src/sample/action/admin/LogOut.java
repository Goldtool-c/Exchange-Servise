package sample.action.admin;

import application.storage.StageStorage;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class LogOut {
    public static void logOut(Button button)
    {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        StageStorage.GENERAL.getLogInStage().show();
    }
}
