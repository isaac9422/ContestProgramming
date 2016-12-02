
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NewMain {

    private static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = buf.readLine();
            if (line == null) {
                break;
            }
            StringTokenizer str = new StringTokenizer(line);
            total = Integer.parseInt(str.nextToken());
            int n = Integer.parseInt(str.nextToken());
            a = new int[n][2];
            for (int i = 0; i < n; i++) {
                str = new StringTokenizer(buf.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                a[i][0] = x;
                a[i][1] = y;
            }
            dp = new int[total + 201][n];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            int ans = go(0, 0);
            System.out.println(ans);
        }
    }
    static int[][] a;
    static int[][] dp;

    private static int go(int sum, int i) {
        if (i == a.length) {
            if (sum > total && sum > 2000 && total + 200 >= sum || sum <= total) {
                return 0;
            } else {
                return -1000000;
            }
        } else if (dp[sum][i] != -1) {
            return dp[sum][i];
        } else {
            int max = go(sum, i + 1);
            if (sum + a[i][0] <= total + 200) {
                max = Math.max(max, go(sum + a[i][0], i + 1) + a[i][1]);
            }
            return dp[sum][i] = max;
        }

    }
}