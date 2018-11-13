package pr3project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author carlos
 */
public class Pr3Project2 {

    final static int pesoMax = 10;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader fileR = new BufferedReader(new FileReader("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjects\\Pr3Project2\\src\\pr3project2\\Pesos2.txt"));
        
        String s = fileR.readLine();
        System.out.println(s);
        String[] as = s.split(",");
        //for(int i = 0; i < as.length; i++) System.out.println(as[i]);
        
        Integer[] intA = new Integer[as.length];
        for(int i = 0; i < as.length; i++) intA[i] = Integer.parseInt(as[i]);
        List<Integer> list = Arrays.asList(intA);
         
        
        CombinationIterable iterable = new CombinationIterable(list);
        Iterator iterator = iterable.iterator();
        
        
        List<Integer> bestComb;
        
        if(iterator.hasNext()){
            bestComb = (List<Integer>) iterator.next();
        } else{
            return;
        }
        
        while(iterator.hasNext()){
        
            List<Integer> comb = (List<Integer>) iterator.next();
            if(pesoTotal(comb) <= pesoMax && comb.size() >= bestComb.size()){
                if(!(comb.size() == bestComb.size() && pesoTotal(comb) > pesoTotal(bestComb))) {
                    bestComb = comb;
                }
            }    
            
        }
        
        System.out.println(bestComb.toString());
    
    
    
    }
    
    private static int pesoTotal(List<Integer> bestComb) {
        int res  = 0;
        for(int i : bestComb){
            res += i; 
        }
        return res;
    }
    
}
