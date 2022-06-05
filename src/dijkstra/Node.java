package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<NodeDirectedEdge> edges;

    public Node(){
        this.edges = new ArrayList<>();
    }

    public List<NodeDirectedEdge> getEdges() {
        return edges;
    }
}
