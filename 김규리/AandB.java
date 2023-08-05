package gitCodding;

import java.io.*;
import java.util.*;

public class AandB {

    static int t_size;
    static int s_size;

    public static void main(String[] args) throws Exception{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String T = br.readLine();
        
        List <String> S_L = new ArrayList<String>();
        List <String> T_L = new ArrayList<String>();

        int result = 1;
        
        for(int i = 0; i < S.length(); i++) {
            S_L.add(S.split("")[i]);
        }
        
        for(int i = 0; i < T.length(); i++) {
            T_L.add(T.split("")[i]);
        }
        
        //System.out.println(T_L);
        
        while(S_L.size() != T_L.size()) {    
        	
            if(T_L.get(T_L.size() - 1).equals("B")) {
                T_L.remove(T_L.size() - 1);
                
                Collections.reverse(T_L);
            }

            else if(T_L.get(T_L.size() - 1).equals("A")) {
                T_L.remove(T_L.size() - 1);
            }   
        }
        
        for(int i = 0; i < S_L.size(); i++) {
            if(T_L.get(i).equals(S_L.get(i))) {
                continue;
            }
            else {
                result = 0;
                break;
            }
        }
        
        System.out.println(result);
    }
}

