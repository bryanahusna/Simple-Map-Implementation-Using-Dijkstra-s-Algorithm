package dijkstra;

public class DijkstraNodeState {
    public enum State{
        NOTHING,
        VISITED_NODE,
        FRINGE_NODE,
        ACTIVE_NODE,
        FROM_NODE,
        TARGET_NODE,
        PATH_NODE
    }

    public String nodeName;
    public String minimumParentName;
    public double minimumDistance;
    public State state;

    public DijkstraNodeState(String nodeName, String minimumParentName, double minimumDistance, State state){
        this.nodeName = nodeName;
        this.minimumParentName = minimumParentName;
        this.minimumDistance = minimumDistance;
        this.state = state;
    }
}
