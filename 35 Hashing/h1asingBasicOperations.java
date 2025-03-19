import java.util.*;
import java.util.HashMap;

public class h1asingBasicOperations {
    public static void main(String args[]){

        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Add data
        hm.put("India", 150);
        hm.put("China", 180);
        hm.put("USA", 120);
        hm.put("Nepal", 75);
        System.out.println(hm);
    
        // Get - O( 1 )
        int population = hm.get("India");
        System.out.println(population);
        
        // ContainsKey  - O( 1 )
        System.out.println(hm.containsKey("USA"));
        System.out.println(hm.containsKey("US"));

        // Remove   -  O ( 1 )
        System.out.println(hm.remove("Nepal"));
    
        // Size  
        System.out.println(hm.size());
        
        // Is Empty
        System.out.println(hm.isEmpty());
        

        //*  To ITERATE on hashmaps
        Set<String> keys = hm.keySet();
        System.out.println(keys);        // OP - [USA, China, India]

        for (String k : keys) {
            System.out.println("Key : "+k+", Vlue : "+hm.get(k));
        }
        
    }    

}
