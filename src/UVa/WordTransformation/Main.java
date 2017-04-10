package UVa.WordTransformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<String> vt = new ArrayList<String>();
    public static HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

    public static int BFS(String g, String h) {
        int n, r = 0;
        String u;
        Queue<String> q = new ArrayDeque<String>();
        q.add(g);
        while (!q.isEmpty()) {
            n = q.size();
            r++;
            for (int i = 0; i < n; i++) {
                u = q.poll();
                for (int o = 0; o < hm.get(u).size(); o++) {
                    if (!vt.contains(hm.get(u).get(o))) {
                        vt.add(hm.get(u).get(o));
                        q.add(hm.get(u).get(o));
                        if (h.equals(hm.get(u).get(o))) {
                            vt.clear();
                            return r;
                        }
                    }
                }
            }
        }
        vt.clear();
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        br.readLine();
        for (int c = 0; c < N; c++) {
            if (c != 0) {
                System.out.println("");
            }
            String s;
            ArrayList<String> d = new ArrayList<String>();
            while (!"*".equals(s = br.readLine())) {
                hm.put(s, new ArrayList<String>());
                d.add(s);
            }
            for (int i = 0; i < hm.size() - 1; i++) {
                s = d.get(i);
                String p;
                ArrayList<String> h = hm.get(s);
                for (int k = i + 1; k < hm.size(); k++) {
                    p = d.get(k);
                    if (s.length() == p.length()) {
                        int w = 0;
                        for (int l = 0; l < p.length(); l++) {
                            if (s.charAt(l) != p.charAt(l)) {
                                w++;
                            }
                        }
                        if (w == 1) {
                            hm.get(s).add(p);
                            hm.get(p).add(s);
                        }
                    }
                }
            }
            StringTokenizer st;
            while ((s = br.readLine()) != null) {
                if (s.equals("0")||s.equals("")) {
                    break;
                }
                st = new StringTokenizer(s);
                String o = st.nextToken();
                String l = st.nextToken();
                int y = BFS(o, l);
                System.out.println(o + " " + l + " " + y);
            }
            hm.clear();
        }
    }
}