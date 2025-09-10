package coe318.lab6;

import java.util.ArrayList;
/**
 *
 * @author hachi
 */
public class Circuit {
    
    ArrayList<Resistor> resistors;
    private static Circuit instance =  null;
    
    public static Circuit getInstance(){
        if(instance == null){
        instance = new Circuit();
        }
        return instance;
    }
    
    private Circuit(){
        this.resistors = new ArrayList<Resistor>();
    }
    
    public void add(Resistor r){
        this.resistors.add(r);
    }
    
    @Override
    public String toString(){
        String circuit = new String();
        
        for(int i=0; i<this.resistors.size(); i++){
            circuit += this.resistors.get(i).toString() + "\n";
        }
        return(circuit);
    }


    
    public static void main(String[] args) {
        
        Circuit c1 = Circuit.getInstance();
        
        Node A = new Node();
        Node B = new Node();
        Node C = new Node();
        Node D = new Node();
        Node E = new Node();
        Node F = new Node();
        Node G = new Node();
        Node H = new Node();
        Node I = new Node();
        Node J = new Node();
        Node K = new Node();
        
        Resistor r1 = new Resistor(30.0, G, J);
        Resistor r2 = new Resistor(0.69, E, C);

        c1.add(r2);
        c1.add(r1);
        System.out.println(c1.toString());
    }
    
}
