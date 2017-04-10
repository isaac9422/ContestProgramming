package UVa.UniqueSnowflakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            int T = Integer.parseInt(br.readLine());
            for(int t=0;t<T;t++){
                int s = Integer.parseInt(br.readLine());
                if(!hm.containsKey(s)){
                    hm.put(s, s);
                }
            }
            System.out.println(hm.size());
        }
    }
}