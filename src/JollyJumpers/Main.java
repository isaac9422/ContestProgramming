package JollyJumpers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, Boolean> ht;
        while (sc.hasNext()) {
            int y = sc.nextInt();
            if (y == 0) {
                break;
            }
            ht = new Hashtable<Integer, Boolean>();
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int i=0;i<y;i++){
                ht.put(i+1, Boolean.FALSE);
                al.add(sc.nextInt());
            }
            ht.put(y, Boolean.TRUE);
            int d;
            for(int i=0;i<y-1;i++){
                d = Math.abs(al.get(i) - al.get(i+1));
                ht.put(d, Boolean.TRUE);
            }
            if(ht.containsValue(Boolean.FALSE)){
                System.out.println("Not jolly");
            }
            else{
                System.out.println("Jolly");
            }
        }
    }
}