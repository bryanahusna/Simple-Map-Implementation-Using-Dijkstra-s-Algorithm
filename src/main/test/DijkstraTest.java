import dijkstra.Dijkstra;
import dijkstra.DijkstraNode;
import dijkstra.Node;
import dijkstra.NodeDirectedEdge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DijkstraTest {
    @Test
    void DijkstraTest1(){
        List<Node> nodes = new ArrayList<>();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);

        A.addEdge(new NodeDirectedEdge(B, 5));
        A.addEdge(new NodeDirectedEdge(C, 15));
        B.addEdge(new NodeDirectedEdge(C, 6));
        D.addEdge(new NodeDirectedEdge(D, 2));

        Dijkstra d = new Dijkstra(nodes);
        List<DijkstraNode> result = d.solve("A", "C");
        Assertions.assertEquals(11, result.get(result.size()-1).getMinimumDistance());
        Assertions.assertEquals(A, result.get(0).getNode());
        Assertions.assertEquals(B, result.get(1).getNode());
        Assertions.assertEquals(C, result.get(2).getNode());
    }
}
