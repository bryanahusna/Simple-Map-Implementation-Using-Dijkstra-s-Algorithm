import com.brunomnsilva.smartgraph.graph.Digraph;
import com.brunomnsilva.smartgraph.graph.DigraphEdgeList;
import com.brunomnsilva.smartgraph.graph.Edge;
import com.brunomnsilva.smartgraph.graph.Vertex;
import com.brunomnsilva.smartgraph.graphview.*;
import controller.MainController;
import dijkstra.Node;
import dijkstra.NodeDirectedEdge;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        GridPane root = loader.load();
        MainController mainController = loader.getController();

        Digraph<String, String> graph = new DigraphEdgeList<>();

        List<Node> nodes = ConfigReader.read(new File(Main.class.getResource("config1.txt").toURI()));
        for(Node n : nodes){
            graph.insertVertex(n.getName());
        }
        for(Node n : nodes){
            for(NodeDirectedEdge e : n.getEdges()){
                graph.insertEdge(n.getName(), e.getToNode().getName(), n.getName() + "-" + e.getToNode().getName() + " " + e.getWeight());
            }
        }

        //graphPanel.update();
        SmartGraphPanel<String, String> graphPanel = new SmartGraphPanel<>(graph, new SmartCircularSortedPlacementStrategy());
        graphPanel.setAutomaticLayout(true);
        //graphPanel.getStylesheets().add("/src/main/java/smartgraph.css");
        mainController.graphPanelParent.getChildren().add(graphPanel);
        //graphPanel.getSt

        Scene scene = new Scene(root, 1280, 720);
        //graphPanel.setPrefWidth(980);
        //graphPanel.setPrefHeight(720);


        primaryStage.setTitle("Dijkstra Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
        graphPanel.init();
        graphPanel.update();
    }
}
