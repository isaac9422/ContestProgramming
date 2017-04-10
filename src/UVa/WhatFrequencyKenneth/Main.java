package UVa.WhatFrequencyKenneth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Character t;
        while((s=br.readLine())!=null){
            char[] g = s.toCharArray();
            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            int m = 0;
            for(int i = 0;i<s.length();i++){
                t = g[i];
                if((t +1>='A'+1 && t +1<= 'Z'+1)||(t +1>='a'+1 && t +1<= 'z'+1)){
                    if(hm.containsKey(t)){
                        int u = hm.get(t);
                        if(u+1>m){
                            m = u + 1;
                        }
                        hm.put(t,u+1);                        
                    }
                    else{
                        hm.put(t, 1);
                        if(m==0){
                            m=1;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for( Iterator it = hm.keySet().iterator(); it.hasNext();) {
                Character e = (Character) it.next();
                if(hm.get(e) == m){
                    sb.append(e);
                }
            }
            char[] y = sb.toString().toCharArray();
            Arrays.sort(y);
            sb.delete(0, sb.length());
            for(int j=0;j<y.length;j++){
                sb.append(y[j]);
            }
            System.out.println(sb+" "+m);
        }
    }
}