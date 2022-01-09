package sample.action.logIn;

import DAO.ParseEntity;
import application.bank.Bank;
import application.criteria.Criteria;
import application.entity.Customer;
import application.entity.CustomerFactory;
import application.entity.Role;
import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;
import application.search.Search;
import application.storage.PersonStorage;
import application.storage.StageStorage;
import application.util.UserNameField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.text.ParseException;
/**
 * Класс, обеспечивающий функционорование logInButton в {@link sample.LogInController}
 * @author Денис Гладышев
 * @version 1.0*/
public class LogIn {
    /**
     *Метод, определяющий поведение кнопки
     * @param logInButton - кнопка
     * @param login - логин
     * @param password - пароль*/
    public static void logIn(Button logInButton, String login, String password)
    {
        Stage stage = (Stage)logInButton.getScene().getWindow();
        Customer user = (Customer) Search.search(PersonStorage.GENERAL, new Criteria("name", login));
        if(user == null)
        {
            PersonStorage.GENERAL.setUser(register(login, password));
            ParseEntity.parse(PersonStorage.GENERAL, "Person");
            UserNameField.customerLabel.setText("Username: " + PersonStorage.GENERAL.getUser().getName());
            StageStorage.GENERAL.getCustomerStage().show();
            stage.close();
        }
        else
        {
            if(password.equals(user.getPassword())) {
                PersonStorage.GENERAL.setUser(user);
                UserNameField.customerLabel.setText("Username: " + PersonStorage.GENERAL.getUser().getName());
                if(user.getRole() == Role.ADMIN) {
                    UserNameField.adminLabel.setText("Username: " + PersonStorage.GENERAL.getUser().getName());
                    StageStorage.GENERAL.getAdminStage().show();
                }
                else{
                    StageStorage.GENERAL.getCustomerStage().show();
                }
                stage.close();
            }
            else
            {
                System.out.println("Incorrect login or password");
            }
        }
        System.out.println("bank: " + Bank.GENERAL.getVault());
        System.out.println("user: " + PersonStorage.GENERAL.getUser().getBalance());
    }
    private static Customer register(String login, String password)
    {
        //{"name", "password", "role", "balance"};
        double rubble = (Math.random()*((10000-100)+1))+100;
        double dollar = (Math.random()*((10000-100)+1))+100;
        double yuan = (Math.random()*((10000-100)+1))+100;
        Customer customer = null;
        try {
            customer = (Customer) CustomerFactory.INSTANCE.create(true, login, password, "CUSTOMER", "RUBBLE "+rubble+"|DOLLAR "+dollar+"|YUAN "+yuan);
        } catch (UnknownRoleException | UnknownCurrencyException | ParseException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
