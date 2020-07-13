package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    public void Thoat(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation( getClass().getResource( "Controller.fxml" ) );
        Parent a = fxmlLoader.load();
        Scene scene = new Scene( a );
        stage.setScene( scene );
    }
    public void add(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation( getClass().getResource( "Add.fxml" ) );
        Parent a = fxmlLoader.load();
        Scene scene = new Scene( a );
        stage.setScene( scene );
    }
    public void show(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation( getClass().getResource( "Baocaochitieu.fxml" ) );
        Parent a = fxmlLoader.load();
        Scene scene = new Scene( a );
        stage.setScene( scene );
    }
    public void search(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation( getClass().getResource( "Search.fxml" ) );
        Parent a = fxmlLoader.load();
        Scene scene = new Scene( a );
        stage.setScene( scene );
    }
    public void delete(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation( getClass().getResource( "Delete.fxml" ) );
        Parent a = fxmlLoader.load();
        Scene scene = new Scene( a );
        stage.setScene( scene );
    }

}
