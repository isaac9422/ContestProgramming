package UVa.Troubleof13Dots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = buf.readLine();
            if (line == null) {
                break;
            }
            StringTokenizer str = new StringTokenizer(line);
            m = Integer.parseInt(str.nextToken());
            n = Integer.parseInt(str.nextToken());
            a = new int[n][2];
            for (int i = 0; i < n; i++) {
                str = new StringTokenizer(buf.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                a[i][0] = x;
                a[i][1] = y;
            }
            //Se le asigna 201 de holgura, porque puede se puede asignar los recursos leidos más 200 
            dp = new int[m + 201][n];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            //Se realiza desde 0 a 0, porque lo que se busca es conseguir la mayor cantidad de vestidos
            int r = knapsack(0, 0);
            System.out.println(r);
        }
    }
    static int[][] a;
    static int[][] dp;

    private static int knapsack(int sum, int i) {
        if (i == a.length) {        //Se evaluaron todos los datos
            //Condicional para evaluar si se puede asignar la promoción y obtener los 200 adicionales
            if (sum > m && sum > 2000 && m + 200 >= sum || sum <= m) {
                return 0;
            } else {
                return -1000000;
            }
        } else if (dp[sum][i] != -1) {  //Valor ya calculado en memoria
            return dp[sum][i];
        } else {
            int max = knapsack(sum, i + 1);
            if (sum + a[i][0] <= m + 200) {         //Paso para indicar que dado el caso, se puede utilizar los 200 adicionales
                max = Math.max(max, knapsack(sum + a[i][0], i + 1) + a[i][1]);
            }
            return dp[sum][i] = max;
        }

    }
}