package dijkstra;

public class DijkstraNode {
    private Node node;
    private DijkstraNode minimumParent;
    private double minimumDistance;
    private boolean isVisited;

    public DijkstraNode(Node node){
        this.node = node;
        this.minimumParent = null;
        this.minimumDistance = Double.POSITIVE_INFINITY;
        this.isVisited = false;
    }

    @Override
    public String toString() {
        return node.getName() + " " + minimumDistance + " Parent: " + (minimumParent != null ? minimumParent.getNode().getName() : "(Source Node)");
    }

    public Node getNode() {
        return node;
    }
    public void setNode(Node node) {
        this.node = node;
    }

    public DijkstraNode getMinimumParent() {
        return minimumParent;
    }
    public void setMinimumParent(DijkstraNode minimumParent) {
        this.minimumParent = minimumParent;
    }

    public double getMinimumDistance() {
        return minimumDistance;
    }
    public void setMinimumDistance(double minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    public boolean isVisited() {
        return isVisited;
    }
    public void setVisited(boolean visited) {
        isVisited = visited;
    }

}
