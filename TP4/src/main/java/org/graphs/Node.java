package org.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final int id;
    private final List<Node>neighbors ;

    public Node(int id){
        this.id = id;
        neighbors = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
    public String getStrNeighbors(){
        StringBuilder stringNeighbors = new StringBuilder("[");
        for (int i = 0; i < neighbors.size(); i++){
            stringNeighbors.append(neighbors.get(i).getId());
            if (i != neighbors.size()- 1){
                stringNeighbors.append(", ");
            }
        }
        stringNeighbors.append(" ]");
        return stringNeighbors.toString();
    }

    public void setNeighbors(Node node){
        neighbors.add(node);
    }
}
