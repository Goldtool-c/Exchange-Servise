package sample;

import DAO.ParseCustomer;
import DAO.ParsePersonFile;
import application.entity.CheckFactory;
import application.entity.CustomerFactory;
import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;
import application.storage.CheckStorage;
import application.storage.PersonStorage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.ParseException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainSample.fxml"));
        primaryStage.setTitle("Exchange");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        Parent logInRoot = FXMLLoader.load(getClass().getResource("LogInSample.fxml"));
        Stage logInStage = new Stage();
        logInStage.setTitle("Log In");
        logInStage.setScene(new Scene(logInRoot, 222, 192));
        logInStage.show();
    }


    public static void main(String[] args) throws ParseException, UnknownCurrencyException, UnknownRoleException {
        //ParsePersonFile.parse(CustomerFactory.INSTANCE, "Person");
        //System.out.println("AllCustomers: " + PersonStorage.GENERAL.get(0));
        //ParsePersonFile.parse(CheckFactory.GENERAL, "Check");
        //System.out.println(PersonStorage.GENERAL.get(0));
        //"date","cashierName", "customerName","customerCurrency","bankCurrency","id"
        //Check check = CheckFactory.GENERAL.create(true, "15.07.2002", "Aguzok", "Chelovek", "RUBBLE", "DOLLAR", "15.0");
        //Customer customer = (Customer) PersonStorage.GENERAL.get(0);
        //System.out.println(customer.getChecks());
        //"date","cashierName", "customerName","customerCurrency","bankCurrency","id"
        //CheckFactory.GENERAL.create(true, "15.07.2002", "popuashka", "Chelovek", "RUBBLE", "DOLLAR", "2.0");
        //System.out.println("ALL Checks: " + CheckStorage.GENERAL.get(0));
        //System.out.println("AllCustomers: " + PersonStorage.GENERAL.get(0));
        //ParseCustomer.parse(CheckStorage.GENERAL, "Check");
        //ParseCustomer.parse(PersonStorage.GENERAL, "Person");
        launch(args);
    }
}
