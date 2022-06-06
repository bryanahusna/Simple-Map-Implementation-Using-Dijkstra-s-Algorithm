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

    public List<DijkstraSnapshot> solveWithStep(String fromName, String toName){
        List<DijkstraNode> result = new ArrayList<>();
        List<DijkstraSnapshot> snapshots = new ArrayList<>();
        DijkstraSnapshot snapshot = new DijkstraSnapshot();

        for(DijkstraNode dn : nodes.values()){
            dn.setMinimumParent(null);
            dn.setMinimumDistance(Double.POSITIVE_INFINITY);
            dn.setVisited(false);
        }
        DijkstraNode fromNode = nodes.get(fromName);
        fromNode.setMinimumDistance(0);
        DijkstraNode toNode = nodes.get(toName);

        snapshot.addState(fromNode.getNode().getName(), "", fromNode.getMinimumDistance(), DijkstraNodeState.State.FROM_NODE);
        snapshot.addState(toNode.getNode().getName(), "", toNode.getMinimumDistance(), DijkstraNodeState.State.TARGET_NODE);
        snapshots.add(snapshot);
        snapshot = new DijkstraSnapshot();

        Queue<DijkstraNode> waitingNodes = new PriorityQueue<>(new Comparator<DijkstraNode>() {
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2) {
                if(o1.getMinimumDistance() > o2.getMinimumDistance())
                    return 1;
                else if(o1.getMinimumDistance() < o2.getMinimumDistance())
                    return -1;
                else
                    return 0;
            }
        });

        DijkstraNode currentNode = fromNode;
        while(currentNode != toNode && currentNode != null){
            snapshots.add(new DijkstraSnapshot(currentNode, DijkstraNodeState.State.ACTIVE_NODE));

            DijkstraNode nextNode = null;
            for(NodeDirectedEdge nde : currentNode.getNode().getEdges()){
                DijkstraNode fringeNode = nodes.get(nde.getToNode().getName());
                if(fringeNode.isVisited()) continue;

                if(currentNode.getMinimumDistance() + nde.getWeight() < fringeNode.getMinimumDistance()){
                    fringeNode.setMinimumParent(currentNode);
                    fringeNode.setMinimumDistance(currentNode.getMinimumDistance() + nde.getWeight());
                }
                snapshots.add(new DijkstraSnapshot(fringeNode, DijkstraNodeState.State.FRINGE_NODE));
                waitingNodes.add(fringeNode);
            }
            currentNode = waitingNodes.poll();
        }

        while(currentNode != fromNode){
            result.add(currentNode);
            currentNode = currentNode.getMinimumParent();
        }
        result.add(fromNode);
        Collections.reverse(result);
        for(DijkstraNode dn : result){
            snapshots.add(new DijkstraSnapshot(dn, DijkstraNodeState.State.PATH_NODE));
        }
        snapshots.add(new DijkstraSnapshot(fromNode, DijkstraNodeState.State.FROM_NODE));
        snapshots.add(new DijkstraSnapshot(toNode, DijkstraNodeState.State.TARGET_NODE));

        return snapshots;
    }
}
