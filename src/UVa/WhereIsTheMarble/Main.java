package UVa.WhereIsTheMarble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int cas = 0;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            Integer N = new Integer(st.nextToken());
            Integer Q = new Integer(st.nextToken());
            StringBuilder sb = new StringBuilder();
            HashMap<Integer, Integer> hm = new HashMap();
            ArrayList<Integer> al = new ArrayList();
            if (N == 0 && Q == 0) {
                break;
            } else {
                cas++;
                for (int i = 0; i < N; i++) {
                    s = br.readLine();
                    Integer k = new Integer(s);
                    al.add(k);
                }
                Collections.sort(al);
                for (int i = 0; i < N; i++) {
                    Integer h = al.get(i);
                    if (hm.containsKey(h)) {
                        int o = hm.get(h);
                        hm.put(h, o + 1);
                    } else {
                        hm.put(h, 1);
                    }
                }
                for (int i = 0; i < Q; i++) {
                    s = br.readLine();
                    int p = 0, q = 0;
                    Integer l = new Integer(s);
                    if (hm.containsKey(l)) {
                        while (al.get(q) < l) {
                            q++;
                            p++;
                        }
                        sb.append(s + " found at " + (p + 1) + "\n");
                    } else {
                        sb.append(s + " not found" + "\n");
                    }
                }
                System.out.println("CASE# " + cas + ":");
                System.out.print(sb);
            }
        }
    }
}