package application.util;

import application.storage.StageStorage;
import javafx.scene.control.Label;
/**
 * Класс. Решает проблему с слишком ранней инициализации окон, содержащихся в {@link StageStorage#GENERAL}
 * со свойствами <b>adminLabel</b>, <b>customerLabel</b>
 * @author Денис Гладышев
 * @version 1.0*/
public class UserNameField {//todo encapsulation
    public static Label adminLabel;
    public static Label customerLabel;
}
