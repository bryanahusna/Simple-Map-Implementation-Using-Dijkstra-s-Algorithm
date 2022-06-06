package controller;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML public Button chooseFileButton;
    @FXML public GridPane root;
    @FXML public Label filePathLabel;
    @FXML public Label minimumWeightLabel;
    @FXML public Label executionTimeLabel;

    StringProperty filePath = new SimpleStringProperty();
    DoubleProperty minimumWeight = new SimpleDoubleProperty();
    DoubleProperty executionTime = new SimpleDoubleProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filePathLabel.textProperty().bind(filePath);
        minimumWeightLabel.textProperty().bind(minimumWeight.asString());
        executionTimeLabel.textProperty().bind(executionTime.asString());
        /*minimumWeight.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                minimumWeightLabel.setText(newValue.toString());
            }
        });
        executionTime.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                executionTimeLabel.setText(newValue.toString());
            }
        });*/

        minimumWeight.set(200);
    }
}
