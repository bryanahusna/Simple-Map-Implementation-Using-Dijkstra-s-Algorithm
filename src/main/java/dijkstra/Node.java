package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<NodeDirectedEdge> edges;

    public Node(){
        this.name = "";
        this.edges = new ArrayList<>();
    }
    public Node(String name){
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public void addEdge(NodeDirectedEdge nde){
        this.edges.add(nde);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<NodeDirectedEdge> getEdges() {
        return edges;
    }
}
