package Continents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static char[][] m;
    public static boolean visited[][];
    static char c;

    public static boolean isValid(int r, int t) {
        return r >= 0 && t >= 0 && t < m[0].length && r < m.length;
    }

    public static int DFS(int x, int y) {
        visited[x][y] = true;
        int ans = 1;
        for (int i = 0; i < 8; i++) {
            int u = x + dx[i];
            int v = (y + dy[i] + m[0].length) % m[0].length;
            if (isValid(u, v) && !visited[u][v] && m[u][v] == c) {
                ans += DFS(u, v);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        boolean flag = true;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            Integer M = new Integer(st.nextToken());
            Integer N = new Integer(st.nextToken());
            m = new char[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                m[i] = br.readLine().toCharArray();
            }
            st = new StringTokenizer(br.readLine());
            Integer x = new Integer(st.nextToken());
            Integer y = new Integer(st.nextToken());
            br.readLine();
            c = m[x][y];
            DFS(x, y);
            int mayor = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (m[i][j] == c && !visited[i][j]) {
                        mayor = Math.max(DFS(i, j), mayor);
                    }
                }
            }
            System.out.println(mayor);
        }
    }
}