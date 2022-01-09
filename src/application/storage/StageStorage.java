package application.storage;

import javafx.stage.Stage;
/**
 * Класс репозиторий для основных окон приложения <b>adminStage</b>, <b>logInStage</b>, <b>customerStage</b>
 * @author Денис Гладышев
 * @version 1.0*/
public enum StageStorage {
    GENERAL;
    private Stage adminStage;
    private Stage logInStage;
    private Stage customerStage;
    /**
     * Метод для получения окна администратора
     * @return окно администратора {@link StageStorage#adminStage}*/
    public Stage getAdminStage() {
        return adminStage;
    }
    /**
     * Метод для задания окна администратора
     * @param adminStage - окно администратора*/
    public void setAdminStage(Stage adminStage) {
        this.adminStage = adminStage;
    }
    /**
     * Метод для получения окна регистрации/входа
     * @return окно регистрации/входа {@link StageStorage#logInStage}*/
    public Stage getLogInStage() {
        return logInStage;
    }
    /**
     * Метод для задания окна регистрации/входа
     * @param logInStage - окно регистрации/входа */
    public void setLogInStage(Stage logInStage) {
        this.logInStage = logInStage;
    }
    /**
     * Метод для получения окна клиента
     * @return окно клиента {@link StageStorage#customerStage}*/
    public Stage getCustomerStage() {
        return customerStage;
    }
    /**
     * Метод для получения окна клиента
     * @param customerStage - окно клиента*/
    public void setCustomerStage(Stage customerStage) {
        this.customerStage = customerStage;
    }
}
