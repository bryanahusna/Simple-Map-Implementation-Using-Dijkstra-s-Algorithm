package dijkstra;

public class NodeDirectedEdge {
    private Node toNode;
    private double weight;

    public NodeDirectedEdge(){
        this.toNode = null;
        this.weight = -1;
    }

    public NodeDirectedEdge(Node toNode, double weight){
        this.toNode = toNode;
        this.weight = weight;
    }

    public void setToNode(Node toNode) {
        this.toNode = toNode;
    }

    public Node getToNode() {
        return toNode;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
}
