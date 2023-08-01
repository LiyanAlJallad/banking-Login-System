package se2203b.assignments.ifinance;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Abdelkader Ouda
 */
public class IFinanceController implements Initializable {

    private UserAccountAdapter userAccAdapter;
    private Connection conn;


    @FXML
    private MenuBar mainMenu;
    @FXML
    private MenuItem loginItem;
    @FXML
    private Menu admin;


    @FXML
    void login() throws IOException, SQLException {
//        userAccAdapter = new UserAccountAdapter(conn, false);
//        userAccAdapter = new UserAccountAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserAccount-view.fxml"));
        Parent login = (Parent) fxmlLoader.load();
        UserAccountController userAccController = (UserAccountController) fxmlLoader.getController();
//        userAccController.(teams);

        Scene scene = new Scene(login);
        Stage stage = new Stage();

        stage.setScene(scene);
//        stage.getIcons().add(new Image("file:src/main/resources/se2203b/lab5/tennisballgames/WesternLogo.png"));
//        stage.setTitle("Add New Team");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();


    }


    public void showAbout() throws Exception {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(IFinanceController.class.getResource("About-view.fxml"));
        // create the root node
        Parent About = fxmlLoader.load();
        // create new stage
        Stage stage = new Stage();
        // add the about's UI elements to the stage
        stage.setScene(new Scene(About));
        // add icon to the About window
        stage.getIcons().add(new Image("file:src/main/resources/se2203b/assignments/ifinance/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void exit() {
        // Get current stage reference
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        // Close stage
        stage.close();
    }

    public void menuVisibility(boolean set) {
        if (set == true) {
            this.admin.setVisible(true);
        } else {
            this.admin.setVisible(false);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            userAccAdapter = new UserAccountAdapter(conn, false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create a named constant for the URL
        // NOTE: This value is specific for Java DB
        String DB_URL = "jdbc:derby:TeamDB;create=true";
        // Create a connection to the database
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // TODO
    }

}
