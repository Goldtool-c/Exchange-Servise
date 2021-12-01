package application.storage;

import javafx.stage.Stage;

public enum StageStorage {
    GENERAL;
    private Stage adminStage;
    private Stage logInStage;
    private Stage customerStage;

    public Stage getAdminStage() {
        return adminStage;
    }

    public void setAdminStage(Stage adminStage) {
        this.adminStage = adminStage;
    }

    public Stage getLogInStage() {
        return logInStage;
    }

    public void setLogInStage(Stage logInStage) {
        this.logInStage = logInStage;
    }

    public Stage getCustomerStage() {
        return customerStage;
    }

    public void setCustomerStage(Stage customerStage) {
        this.customerStage = customerStage;
    }
}
