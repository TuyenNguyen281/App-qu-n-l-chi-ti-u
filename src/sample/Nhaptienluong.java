package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.awt.*;
import java.io.IOException;

public class Nhaptienluong {
    @FXML
    private TextField nhaptienluong;

    public static int tong = 0;

    public void cancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( getClass().getResource( "Baocaochitieu.fxml" ) );
        Parent dashboardView = loader.load();
        Scene scene = new Scene( dashboardView );
        stage.setScene( scene );
    }

    public void ok(ActionEvent event) throws IOException {
        String text = nhaptienluong.getText();
        tong = Integer.valueOf( text );
    }
}
