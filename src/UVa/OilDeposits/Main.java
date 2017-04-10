package UVa.OilDeposits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] oil;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};

    public static boolean Pertenece(int y, int r) {
        if (y < oil.length && r < oil[0].length && y >= 0 && r >= 0) {
            return true;
        }
        return false;
    }

    public static void BTc(int k, int y) {
        if (oil[k][y] == false) {
        } else {
            oil[k][y] = false;
            for (int q = 0; q < 8; q++) {
                if (Pertenece(k + dx[q], y + dy[q])) {
                    if (oil[k + dx[q]][y + dy[q]]) {
                        BTc(k + dx[q], y + dy[q]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            Integer m = new Integer(st.nextToken());
            Integer n = new Integer(st.nextToken());
            oil = new boolean[m][n];
            if (m == 0) {
                break;
            } else {
                int p = 0;
                for (int i = 0; i < m; i++) {
                    s = br.readLine();
                    for (int j = 0; j < n; j++) {
                        if (s.charAt(j) == '@') {
                            oil[i][j] = true;
                        }
                    }
                }
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (oil[i][j]) {
                            BTc(i, j);
                            p++;
                        }
                    }
                }
                System.out.println(p);
            }
        }
    }
}