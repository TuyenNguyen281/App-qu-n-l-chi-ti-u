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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.readFilewriteFile.ReadAndWriteFile;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Add implements Initializable {
    List<Spend> listSpend = new ArrayList<>();


    @FXML
    private TextField khoanchi1;
    @FXML
    private TextField sotien;
    @FXML
    private DatePicker time1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addSpend(ActionEvent event) throws IOException {
        List<Spend> spends = ReadAndWriteFile.readFile();
        int id;

        if (spends.size() == 0)  {
            id = 0;
        } else {
            id = (spends.get( spends.size()  - 1).getId() + 1);
        }

        String name = khoanchi1.getText();
        int chiphi = Integer.parseInt( sotien.getText() );
        LocalDate date = time1.getValue();
        Spend spend = new Spend(id, name, chiphi, date );
        spends.add( spend );

        ReadAndWriteFile.writeFile( spends );
    }

    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( getClass().getResource( "Menu.fxml" ) );
        Parent dashboardView = loader.load();
        Scene scene = new Scene( dashboardView );
        stage.setScene( scene );
    }


}
