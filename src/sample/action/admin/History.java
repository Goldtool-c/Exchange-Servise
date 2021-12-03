package sample.action.admin;

import application.entity.Check;
import application.exception.InValidDateException;
import application.storage.CheckStorage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class History {
    public static void getHistory(TextField first, TextField second) throws ParseException, InValidDateException {
        String fromStr = first.getText();
        String toStr = second.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date from = format.parse(fromStr);
        Date to = format.parse(toStr);
        StringBuilder sb = new StringBuilder();
        if(isValid(from, to))
        {
            Check temp;
            for (int i = 0; i < CheckStorage.GENERAL.size(); i++) {//todo binary search
                temp = (Check) CheckStorage.GENERAL.get(i);
                if(temp.getDate().getTime()>=from.getTime()&&temp.getDate().getTime()<=to.getTime())
                {
                    sb.append(temp);
                    sb.append("\n");
                }
            }
            Stage stage = new Stage();
            AnchorPane root = new AnchorPane();
            Label history = new Label();
            history.setText(sb.toString());
            root.getChildren().addAll(history);
            stage.setScene(new Scene(root, 500, 200));
            stage.setTitle("History");
            stage.show();
        }
    }
    private static boolean isValid(Date from, Date to) throws InValidDateException {
        if(to.getTime()-from.getTime()>0)
        {
            return true;
        } else
        {
            throw new InValidDateException("Invalid date");
        }
    }
}
