package CarasSellosConsecutivos;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        Hashtable<String, Integer> ht;
        for(int i=0;i<P;i++){
            int b = sc.nextInt();
            ht = new Hashtable<String, Integer>();
            ht.put("SSS", 0);
            ht.put("SSC", 0);
            ht.put("SCS", 0);
            ht.put("SCC", 0);
            ht.put("CSS", 0);
            ht.put("CSC", 0);
            ht.put("CCS", 0);
            ht.put("CCC", 0);
            String g;
            String s = sc.next();
            for(int l=0;l<38;l++){
                g = s.substring(l, l+3);
                int y = ht.get(g);
                y++;
                ht.put(g, y);
            }
            System.out.println((i+1)+" "+ht.get("SSS")+" "+ht.get("SSC")+" "+ht.get("SCS")+" "+ht.get("SCC")+" "+ht.get("CSS")
            +" "+ht.get("CSC")+" "+ht.get("CCS")+" "+ht.get("CCC"));
        }
    }
}