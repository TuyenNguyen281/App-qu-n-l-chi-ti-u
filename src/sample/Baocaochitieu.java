package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.readFilewriteFile.ReadAndWriteFile;
import javafx.scene.control.TextField;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Baocaochitieu implements Initializable {
    @FXML
    private TableView<Spend> table1;
    @FXML
    private TableColumn<Spend, String> colum0;
    @FXML
    private TableColumn<Spend, String> colum1;
    @FXML
    private TableColumn<Spend, Integer> colum2;
    @FXML
    private TableColumn<Spend, LocalDate> colum3;
    @FXML
    private Label tongtien;
    @FXML
    private Label conlai;
    @FXML
    private Label tienluong;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Spend> spends = ReadAndWriteFile.readFile();

        colum0.setCellValueFactory(new PropertyValueFactory<Spend, String>("id"));
        colum1.setCellValueFactory(new PropertyValueFactory<Spend, String>("nameSpend"));
        colum2.setCellValueFactory( new PropertyValueFactory<Spend, Integer>("chiphi"));
        colum3.setCellValueFactory( new PropertyValueFactory<Spend, LocalDate>("date"));

        table1.getItems().addAll(spends);

        int sum = 0;
        for (int i = 0 ; i <spends.size(); i ++ ) {
            sum = sum + spends.get( i ).getChiphi();
        }
        tongtien.setText( String.valueOf( sum ) );

        tienluong.setText( String.valueOf(  Nhaptienluong.tong ));

        int result = 0;
        result = Nhaptienluong.tong - sum;
        conlai.setText( String.valueOf( result ) );

    }

    public void nhaptienluong (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Nhaptienluong.fxml"));
        Parent dashboardView = loader.load();
        Scene scene = new Scene(dashboardView);
        stage.setScene(scene);
    }
    public void cancel (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent dashboardView = loader.load();
        Scene scene = new Scene(dashboardView);
        stage.setScene(scene);
    }

}
