import dijkstra.Node;
import dijkstra.NodeDirectedEdge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ConfigReader {
    public static List<Node> read(String path) throws FileNotFoundException {
        return ConfigReader.read(new File(path));
    }

    public static List<Node> read(File file) throws FileNotFoundException {
        Map<String,Node> nodes = new HashMap<>();
        Node from;
        Node to;

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String[] line = scanner.nextLine().split("\\s+");
            if(line.length != 3) continue;
            double weight;
            try{
                weight = Double.parseDouble(line[2]);
            } catch (Exception e){
                continue;
            }

            if(( from = nodes.get(line[0]) ) == null){
                from = new Node(line[0]);
                nodes.put(from.getName(), from);
            }
            if(( to = nodes.get(line[1]) ) == null){
                to = new Node(line[1]);
                nodes.put(to.getName(), to);
            }

            from.addEdge(new NodeDirectedEdge(to, weight));
        }

        return new ArrayList<>(nodes.values());
    }
}
