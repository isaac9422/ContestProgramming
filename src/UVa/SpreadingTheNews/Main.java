package UVa.SpreadingTheNews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Integer E;
    public static void copy(boolean[][] m, HashMap hm) {
        for (int i = 0; i < hm.size(); i++) {
            StringTokenizer st = new StringTokenizer((String) hm.get(i));
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            m[x][y] = true;
        }
    }

    public static void BFS(boolean[][] m, Integer b) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        LinkedList<Integer> p = new LinkedList<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(b);
        for (int i = 0; i < E; i++) {
            if (m[b][i]) {
                m[b][i] = false;
                hm.put(hm.size(), new String(b + " " + i));
                p.add(i);
                hs.add(i);
            }
        }
        if (p.size() == 0) {
            System.out.println("0");
        } else {
            int M = p.size();
            int D = 1;
            int y = 1;
            while (!p.isEmpty()) {
                y++;
                int n = p.size();
                for (int l = 0; l < n; l++) {
                    int h = p.poll();
                    for (int i = 0; i < E; i++) {
                        if (m[h][i] && !hs.contains(i)) {
                            m[h][i] = false;
                            hm.put(hm.size(), new String(h + " " + i));
                            p.add(i);
                            hs.add(i);
                        }
                    }
                }
                if (p.size() > M) {
                    M = p.size();
                    D = y;
                }
            }
            System.out.println(M + " " + D);
        }
        copy(m, hm);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        E = new Integer(br.readLine());
        boolean[][] m = new boolean[E][E];
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer N = new Integer(st.nextToken());
            for (int j = 0; j < N; j++) {
                Integer P = new Integer(st.nextToken());
                if (i != P) {
                    m[i][P] = true;
                }
            }
        }
        Integer T = new Integer(br.readLine());
        for (int c = 0; c < T; c++) {
            Integer b = new Integer(br.readLine());
            BFS(m, b);
        }
    }
}