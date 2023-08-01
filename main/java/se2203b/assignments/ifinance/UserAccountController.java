package se2203b.assignments.ifinance;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserAccountController implements Initializable {

    private UserAccountAdapter userAccountAdapter;
    private UserAccount userAccount;
    private IFinanceController IFinanceController = new IFinanceController();


    @FXML
    private TextField password;
    @FXML
    private TextField userName;
    @FXML
    private AnchorPane pane;

    private Connection conn;

    @FXML
    private Button cancelBtn;

    @FXML
    void passwordText() {
//        TextFormatter<String> formatter = new TextFormatter<>(change -> {
//            if (change.isAdded()) {
//                int length = change.getText().length();
//                StringBuilder dots = new StringBuilder();
//                for (int i = 0; i < length; i++) {
//                    dots.append("*");
//                }
//                change.setText(dots.toString());
//            }
//            return change;
//        });
//        password.setTextFormatter(formatter);

    }

    @FXML
    void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    private Button OKBtn;

    @FXML
    void OK() throws SQLException {
        userAccount = new UserAccount();

        if (userName.getText().isEmpty()) {
            Label label = new Label("Error: please enter a userName.");
            pane.getChildren().add(label);
        }

        if (password.getText().isEmpty()) {
            Label label = new Label("\nError: please enter a password.");
            pane.getChildren().add(label);
        }

        if (userName.getText().equals("admin") && password.getText().equals("admin")) {
            userAccount.setUserName(userName.getText());
            userAccount.setPassword(password.getText());
            userAccount.setAccType("Admin");

//            userAccountAdapter.addUserAccount(userAccount);

            Label label = new Label("\nlogin successful.");
            pane.getChildren().add(label);
            IFinanceController.menuVisibility(true);

        } else {
            userAccount.setAccType("NonAdmin");

            Label label = new Label("login fails.");
            pane.getChildren().add(label);

        }
    }


    private void closeWindow() {
        Stage stage = (Stage) OKBtn.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IFinanceController.menuVisibility(false);
        //try {
        //  conn = DriverManager.getConnection("jdbc:sqlite:user_accounts.db");
//            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
//          //  userAccountAdapter = new UserAccountAdapter(conn, true);
        //} catch (SQLException e) {
        //  System.out.println(e.getMessage());
        //}

//        try {
//            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
//            userAccountAdapter = new UserAccountAdapter(conn, true);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }


}
