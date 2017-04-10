package UVa.Battleships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static char[][] grid;

    public static boolean isValid(int r, int t) {
        return r >= 0 && t >= 0 && r < grid.length && t < grid[0].length;
    }

    public static void DFS(int i, int j) {

        grid[i][j] = '.';
        for (int l = 0; l < 4; l++) {
            if (isValid(i + dx[l], j + dy[l]) && grid[i+dx[l]][j+dy[l]] != '.') {
                DFS(i + dx[l], j + dy[l]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Integer T = new Integer(br.readLine());
        for (int c = 0; c < T; c++) {
            Integer N = new Integer(br.readLine());
            grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            int r = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 'x') {
                        DFS(i, j);
                        r++;
                    }
                }
            }
            System.out.println("Case " + (c + 1) + ": " + r);
        }
    }
}