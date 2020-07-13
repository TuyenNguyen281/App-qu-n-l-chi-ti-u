package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.readFilewriteFile.ReadAndWriteFile;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Search implements Initializable {

    @FXML
    private TableView<Spend> table2;
    @FXML
    private TableColumn<Spend, String> colum0;
    @FXML
    private TableColumn<Spend, String> colum1;
    @FXML
    private TableColumn<Spend, Integer> colum2;
    @FXML
    private TableColumn<Spend, LocalDate> colum3;

    @FXML
    private DatePicker ngay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colum0.setCellValueFactory( new PropertyValueFactory<Spend, String>( "id" ) );
        colum1.setCellValueFactory( new PropertyValueFactory<Spend, String>( "nameSpend" ) );
        colum2.setCellValueFactory( new PropertyValueFactory<Spend, Integer>( "chiphi" ) );
        colum3.setCellValueFactory( new PropertyValueFactory<Spend, LocalDate>( "date" ) );
        table2.getItems().clear();
        table2.getItems().addAll(ReadAndWriteFile.readFile() );

    }

    public void search() {
        List<Spend> spends;
        List<Spend> spend1 = new ArrayList<>();

        spends = ReadAndWriteFile.readFile();
        for (int i = 0; i < spends.size(); i++) {
            if (ngay.getValue().equals( spends.get( i ).getDate() )) {
                spend1.add( spends.get( i ) );
            }
        }


        table2.getItems().clear();
        table2.getItems().addAll( spend1 );
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
