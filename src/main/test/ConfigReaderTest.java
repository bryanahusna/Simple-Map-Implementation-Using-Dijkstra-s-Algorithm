import dijkstra.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

public class ConfigReaderTest {
    @Test
    void configReaderTest() throws URISyntaxException, FileNotFoundException {
        List<Node> nodes = ConfigReader.read(new File(ConfigReader.class.getResource("config1.txt").toURI()));
        boolean isFound = false;
        for(Node n : nodes){
            System.out.println(n);
            if(n.getName().equals("A")){
                isFound = true;
            }
        }
        if(!isFound){
            Assertions.fail("Ada node yang tidak terbaca");
        }
    }
}
