package dijkstra;

import java.util.*;

public class Dijkstra {
    private final Map<String, DijkstraNode> nodes;

    public Dijkstra(List<Node> nodes){
        this.nodes = new HashMap<>();
        for (Node n : nodes) {
            this.nodes.put(n.getName(), new DijkstraNode(n));
        }
    }

    public List<DijkstraNode> solve(Node fromNode, Node toNode){
        return this.solve(fromNode.getName(), toNode.getName());
    }

    public List<DijkstraNode> solve(String fromName, String toName){
        List<DijkstraNode> result = new ArrayList<>();

        for(DijkstraNode dn : nodes.values()){
            dn.setMinimumParent(null);
            dn.setMinimumDistance(Double.POSITIVE_INFINITY);
            dn.setVisited(false);
        }
        DijkstraNode fromNode = nodes.get(fromName);
        fromNode.setMinimumDistance(0);
        DijkstraNode toNode = nodes.get(toName);

        DijkstraNode currentNode = fromNode;
        while(currentNode != toNode){
            DijkstraNode nextNode = null;
            for(NodeDirectedEdge nde : currentNode.getNode().getEdges()){
                DijkstraNode fringeNode = nodes.get(nde.getToNode().getName());
                if(fringeNode.isVisited()) continue;

                if(currentNode.getMinimumDistance() + nde.getWeight() < fringeNode.getMinimumDistance()){
                    fringeNode.setMinimumParent(currentNode);
                    fringeNode.setMinimumDistance(currentNode.getMinimumDistance() + nde.getWeight());
                }
                if(nextNode == null || fringeNode.getMinimumDistance() < nextNode.getMinimumDistance()){
                    nextNode = fringeNode;
                }
            }
            currentNode = nextNode;
        }

        while(currentNode != fromNode){
            result.add(currentNode);
            currentNode = currentNode.getMinimumParent();
        }
        result.add(fromNode);
        Collections.reverse(result);

        return result;
    }
}
