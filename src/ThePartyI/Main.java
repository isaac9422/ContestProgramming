package ThePartyI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int P, D;
    static int[][] m;

    static void BFS() {
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        hm.put(0, Boolean.TRUE);
        for (int i = 1; i < P; i++) {
            hm.put(i, Boolean.FALSE);
        }
        q.add(0);
        int l = 0;
        while (!q.isEmpty()) {
            l++;
            int y = q.size();
            for (int o = 0; o < y; o++) {
                int u = q.poll();
                for (int i = 0; i < P; i++) {
                    if (m[u][i] == 1 && hm.get(i) == false & i != u) {
                        m[u][i] = 0;
                        hm.put(i, Boolean.TRUE);
                        ht.put(i, l);
                        q.add(i);
                    }
                }
            }
        }
        for (int i = 1; i <= P - 1; i++) {
            if (ht.get(i) != 0) {
                System.out.println(ht.get(i));
            } else {
                System.out.println("INF");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            if (i != 0) {
                System.out.println("");
            }
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            m = new int[P][P];
            for (int j = 0; j < D; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                m[a][b] = 1;
                m[b][a] = 1;
            }
            BFS();
        }
    }
}