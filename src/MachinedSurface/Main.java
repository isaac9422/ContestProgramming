package MachinedSurface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static int X(String g){
        g = g.replaceAll("X", "");
        return g.length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            if(Integer.parseInt(s)==0){
                break;
            }
            else{
                int r = 0,m = 24;
                HashMap hm = new HashMap();
                Integer f = new Integer(s);
                for(int i=0;i<f;i++){
                    int c = X(br.readLine());
                    if(c<m){
                        m=c;
                    }
                    hm.put(i, c);
                }
                for(int i=0;i<f;i++){
                    r+= ((Integer)hm.get(i)-m);                    
                }
                System.out.println(r);
            }
        }
    }
}