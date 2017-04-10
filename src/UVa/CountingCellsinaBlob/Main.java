package UVa.CountingCellsinaBlob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    public static char[][] m;

    public static boolean isValid(int r, int t) {
        return r >= 0 && t >= 0 && t < m[0].length && r < m.length;
    }

    public static int DFS(int i, int j) {
        if (m[i][j] != '1') {
            return 0;
        } else {
            m[i][j] = '.';
            int ans = 1;
            for (int l = 0; l < 8; l++) {
                if (isValid(i + dx[l], dy[l] + j)) {
                    ans += DFS(i + dx[l], j + dy[l]);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = new Integer(br.readLine());
        for (int c = 0; c < T; c++) {
            br.readLine();
            String s = br.readLine();
            int n = s.length();
            m = new char[n][n];
            m[0] = s.toCharArray();
            for (int i = 1; i < n; i++) {
                m[i] = br.readLine().toCharArray();
            }
            int mayor = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (m[i][j] == '1') {
                        int k = DFS(i, j);
                        if (k > mayor) {
                            mayor = k;
                        }
                    }
                }
            }
            if (c == 0) {
                System.out.println(mayor);
            } else {
                System.out.println();
                System.out.println(mayor);
            }
        }
    }
}