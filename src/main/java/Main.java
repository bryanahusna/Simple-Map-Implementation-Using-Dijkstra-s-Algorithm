import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        GridPane root = loader.load();
        MainController mainController = loader.getController();

        Scene scene = new Scene(root, 1280, 720);

        primaryStage.setTitle("Dijkstra Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
