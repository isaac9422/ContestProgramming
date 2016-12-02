package Babelfish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        HashMap<String,String> hm = new HashMap<String,String>();
        while ((s = br.readLine()) != null) {
            if(s.equals("")){
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            while (st.countTokens()==2) {
                String j = st.nextToken();
                String g = st.nextToken();
                hm.put(g, j);
            }
        }
        while ((s = br.readLine()) != null) {
            if (hm.containsKey(s)) {
                System.out.println(hm.get(s));
            } else {
                System.out.println("eh");
            }
        }
    }
}