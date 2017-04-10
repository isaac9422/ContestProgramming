package UVa.BallotEvaluation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        HashMap<String, Float> ht = new HashMap<String, Float>();
        StringBuilder sb = new StringBuilder();
        String s;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            float t = Float.parseFloat(st.nextToken()) *10;
            ht.put(s, t);
        }
        for (int c = 1; c <= g; c++) {
            boolean flag = false;
            s = br.readLine();
            String[] hs = s.split(" ");
            int t=0;
            int le = hs.length;
            for(int i=0;i<=le-2;i+=2){
                t += ht.get(hs[i]);
            }
            String COMP = hs[le-2];
            int n = Integer.parseInt(hs[le-1]) * 10;
            char com = COMP.charAt(0);
            if (COMP.length() == 1) {
                if (com == '<') {
                    if (t < n) {
                        flag = true;
                    }
                } else if (com == '=') {    
                    if (n == t) {
                        flag = true;
                    }
                } else {
                    if (t > n) {
                        flag = true;
                    }
                }
            } else {
                if (com == '<') {
                    if (t <= n) {
                        flag = true;
                    }
                } else {
                    if (t >= n) {
                        flag = true;
                    }
                }
            }
            sb.append("Guess #");
            sb.append(c);
            if (flag) {
                sb.append(" was correct.");
            } else {
                sb.append(" was incorrect.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}