package sample.action.admin;

import application.storage.StageStorage;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**Класс обеспечивает работу кнопки logOutButton в {@link sample.Controller} и {@link sample.CustomerController},
 * выполняя задачу выхода из аккаунта
 * @author Денис Гладышев
 * @version 1.0
 * */
public class LogOut {
    /**
     * Метод, описывающий поведение кнопки
     * @param button - logOutButton в {@link sample.Controller}*/
    public static void logOut(Button button)
    {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        StageStorage.GENERAL.getLogInStage().show();
    }
}
