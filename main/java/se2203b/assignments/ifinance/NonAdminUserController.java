package se2203b.assignments.ifinance;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NonAdminUserController implements Initializable {
    @FXML
    private TextField fullName;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;

    @FXML
    void passwordText() {
    }

    @FXML
    void confirmPasswordText() {
    }

    @FXML
    void cancel() {
    }

    @FXML
    void save() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
