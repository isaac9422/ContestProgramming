
package UVa.Cost_Cutting;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        Integer t = new Integer(br.readLine());
        for(int i=0;i<t;i++){
            tk = new StringTokenizer(br.readLine());
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(new Integer(tk.nextToken()));
            al.add(new Integer(tk.nextToken()));
            al.add(new Integer(tk.nextToken()));
            Collections.sort(al);
            System.out.println("Case "+(i+1)+": "+al.get(1));
        }
    }
}