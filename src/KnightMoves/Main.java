package KnightMoves;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<String> vt = new ArrayList<String>();
    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean isCorrected(int x, int y) {
        return x >= 0 && y > 0 && x < 8 && y <= 8;
    }

    public static int BFS(String x, String y) {
        Queue<String> q = new ArrayDeque<String>();
        int n = 0, r = 0;
        if (x.equals(y)) {
            return r;
        }
        q.add(x);
        String u;
        while (!q.isEmpty()) {
            n = q.size();
            r++;
            for (int i = 0; i < n; i++) {
                u = q.poll();
                char[] l = u.toCharArray();
                char t;
                int p;
                for (int j = 0; j < 8; j++) {
                    t = (char) (l[0] + dx[j]);
                    p = Integer.parseInt(String.valueOf(l[1])) + dy[j];
                    StringBuilder sb = new StringBuilder();
                    sb.append(t);
                    sb.append(p);
                    if (isCorrected(t - 'a', p) && !vt.contains(sb.toString())) {
                        vt.add(sb.toString());
                        q.add(sb.toString());
                        if (sb.toString().equals(y)) {
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
        StringTokenizer tk;
        String s;
        while ((s = br.readLine()) != null) {
            if (s.equals("0")) {
                break;
            }
            tk = new StringTokenizer(s);
            String xx = tk.nextToken();
            String yy = tk.nextToken();
            int n = BFS(xx, yy);
            System.out.println("To get from " + xx + " to " + yy + " takes " + n + " knight moves.");
        }
    }
}