package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.readFilewriteFile.ReadAndWriteFile;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Delete implements Initializable {


    List<Spend> spend1 = new ArrayList<>();
    List<Spend> spend2 = new ArrayList<>();
    List<Spend> spend3 = new ArrayList<>();

    @FXML
    private TextField stt;

    @FXML
    private TableView<Spend> table3;
    @FXML
    private TableColumn<Spend, String> colum0;
    @FXML
    private TableColumn<Spend, String> colum1;
    @FXML
    private TableColumn<Spend, Integer> colum2;
    @FXML
    private TableColumn<Spend, LocalDate> colum3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        spend1 = ReadAndWriteFile.readFile();
        colum0.setCellValueFactory( new PropertyValueFactory<Spend, String>( "id" ) );
        colum1.setCellValueFactory( new PropertyValueFactory<Spend, String>( "nameSpend" ) );
        colum2.setCellValueFactory( new PropertyValueFactory<Spend, Integer>( "chiphi" ) );
        colum3.setCellValueFactory( new PropertyValueFactory<Spend, LocalDate>( "date" ) );

        table3.getItems().clear();
        table3.getItems().addAll( spend1 );

    }

    public void delete() {

        for (int i = 0; i < spend1.size(); i++) {

            if ( Integer.parseInt(stt.getText()) ==  spend1.get( i ).getId() ) {
                spend1.remove( spend1.get( i ) );
            }
        }
        ReadAndWriteFile.writeFile( spend1 );
        spend2 = ReadAndWriteFile.readFile();

        table3.getItems().clear();
        table3.getItems().addAll( spend2 );

    }
    public void deleteAll() {
        spend2.clear();
        ReadAndWriteFile.writeFile( spend2 );
        spend3 = ReadAndWriteFile.readFile();

        table3.getItems().clear();
        table3.getItems().addAll( spend3 );

    }

    public void cancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( getClass().getResource( "Menu.fxml" ) );
        Parent dashboardView = loader.load();
        Scene scene = new Scene( dashboardView );
        stage.setScene( scene );
    }


}
