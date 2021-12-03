package sample;

import DAO.ParseCurrentDate;
import DAO.ParseDateFile;
import DAO.ParseEntity;
import DAO.ParseFile;
import application.bank.Bank;
import application.entity.CheckFactory;
import application.entity.CustomerFactory;
import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;
import application.storage.CheckStorage;
import application.storage.PersonStorage;
import application.storage.StageStorage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.text.ParseException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //admin stage
        Parent root = FXMLLoader.load(getClass().getResource("MainSample.fxml"));
        primaryStage.setTitle("Exchange");
        primaryStage.setScene(new Scene(root, 600, 400));
        StageStorage.GENERAL.setAdminStage(primaryStage);
        Parent customerRoot = FXMLLoader.load(getClass().getResource("CustomerSample.fxml"));
        //customer stage
        Stage customerStage = new Stage();
        customerStage.setTitle("Exchange");
        customerStage.setScene(new Scene(customerRoot, 600, 400));
        StageStorage.GENERAL.setCustomerStage(customerStage);
        //login stage
        Parent logInRoot = FXMLLoader.load(getClass().getResource("LogInSample.fxml"));
        Stage logInStage = new Stage();
        logInStage.setTitle("Log In");
        logInStage.setScene(new Scene(logInRoot, 222, 192));
        StageStorage.GENERAL.setLogInStage(logInStage);
        logInStage.show();
    }


    public static void main(String[] args) {
        ParseFile.parse(CustomerFactory.INSTANCE, "Person");
        ParseFile.parse(CheckFactory.GENERAL, "Check");
        ParseDateFile.parse();
        System.out.println(Bank.GENERAL.getCurrentDate());
        Bank.GENERAL.incDate();
        ParseCurrentDate.parse();
        ParseEntity.parse(CheckStorage.GENERAL, "Check");
        ParseEntity.parse(PersonStorage.GENERAL, "Person");
        launch(args);
    }
}
