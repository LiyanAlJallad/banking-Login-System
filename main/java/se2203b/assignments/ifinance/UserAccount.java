package se2203b.assignments.ifinance;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

//USE THIS
public class UserAccount {
    //    private IntegerProperty userID;
    private StringProperty userName;
    private StringProperty password;
    private StringProperty accType;
//    private BooleanProperty AccessPrivilege;

    //add expiry date for pass
    //ADD account type... this will create the data base

    public UserAccount(String userName, String password, String accType) {
//        this.userID = new SimpleIntegerProperty();
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
        this.accType = new SimpleStringProperty(accType);
    }

    public UserAccount() {
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
//        this.userName.set(userName);
        this.userName = new SimpleStringProperty(userName);

    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getAccType() {
        return accType.get();
    }

    public void setAccType(String accType) {
        this.accType = new SimpleStringProperty(accType);
    }

    public StringProperty accTypeProperty() {
        return accType;
    }

}
