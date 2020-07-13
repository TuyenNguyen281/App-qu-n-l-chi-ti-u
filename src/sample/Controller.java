package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    String user = "A";
    String pass = "1";


    @FXML
    public TextField userNameID;
    @FXML
    private PasswordField passwordID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void dashBoardView(ActionEvent event) throws IOException {
        String name = userNameID.getText();
        String passw = passwordID.getText();
        if (name.equals( user ) && passw.equals( pass )) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            Parent dashboardView = loader.load();
            Scene scene = new Scene(dashboardView);
            stage.setScene(scene);
//            Alert alert = new Alert( Alert.AlertType.CONFIRMATION);
//            alert.setHeaderText(null);
//            alert.setContentText("Đăng nhập thành công");
//            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Đăng nhập thất bại");
            alert.showAndWait();

        }

    }

    public void cancel(ActionEvent actionEvent) {
        userNameID.setText("");
        passwordID.setText("");
    }
}
