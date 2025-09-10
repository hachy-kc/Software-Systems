package coe318.lab6;

/**
 *
 * @author hachi
 */
public class Node {

    private int nodeId;
    private static int node_count = 0; 

    public Node(){
       this.nodeId = node_count;
       node_count++;
    }

    @Override
    public String toString(){
        return("" + this.nodeId);
    }
} 