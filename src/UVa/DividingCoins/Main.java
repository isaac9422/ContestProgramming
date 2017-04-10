package UVa.DividingCoins;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[][] dp;//Modificar de acuerdo al problem
    static int[] W;
    static int n;

    static int knapsack(int id, int recursosS) {
        if (recursosS <= 0) {
            return 0; //si no tengo recursos
        }
        if (id == n) {
            return 0; //si ya chequee todos los elementos
        }
        if (dp[id][recursosS] != 0) {
            return dp[id][recursosS];//si ya tengo el estado en memoria
        }
        if (recursosS < W[id]) {//si no puedo agregar este elemento
            return knapsack(id + 1, recursosS);
        }
        dp[id][recursosS] = Math.max(knapsack(id + 1, recursosS), W[id] + knapsack(id + 1, recursosS - W[id]));//maximo entre tomar y no tomar
        return dp[id][recursosS];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            n = m;
            W = new int[m];
            int m1 = 0,s, m2 = 0;
            for (int j = 0; j < m; j++) {
                s = sc.nextInt();
                W[j] = s;
                m1 += s;
            }
            m2 = ((m1+1) / 2);
            dp = new int[n][m2+1];
            int k = knapsack(0, m2);
            System.out.println(Math.abs(m1- (2 *k)));
        }
    }
}