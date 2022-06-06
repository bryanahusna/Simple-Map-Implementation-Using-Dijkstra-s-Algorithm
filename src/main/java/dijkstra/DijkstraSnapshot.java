package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DijkstraSnapshot {
    private final List<DijkstraNodeState> states;

    public DijkstraSnapshot(){
        this.states = new ArrayList<>();
    }
    public DijkstraSnapshot(String nodeName, String parentName, double minimumDistance, DijkstraNodeState.State state){
        this.states = new ArrayList<>();
        this.addState(new DijkstraNodeState(nodeName, parentName, minimumDistance, state));
    }
    public DijkstraSnapshot(DijkstraNode dn, DijkstraNodeState.State state){
        this.states = new ArrayList<>();
        this.addState(dn, state);
    }

    public void addState(DijkstraNodeState dns){
        this.states.add(dns);
    }
    public void addState(String nodeName, String minimumParentName, double minimumDistance, DijkstraNodeState.State state){
        this.addState(new DijkstraNodeState(nodeName, minimumParentName, minimumDistance, state));
    }
    public void addState(DijkstraNode dn, DijkstraNodeState.State state){
        this.addState(new DijkstraNodeState(dn.getNode().getName(), dn.getMinimumParent().getNode().getName(), dn.getMinimumDistance(), state));
    }

    public List<DijkstraNodeState> getStates() {
        return states;
    }
}
