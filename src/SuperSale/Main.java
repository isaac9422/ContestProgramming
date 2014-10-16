package SuperSale;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[][] dp;//Modificar de acuerdo al problem
    static int[] W;
    static int[] P;
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
        dp[id][recursosS] = Math.max(knapsack(id + 1, recursosS), P[id] + knapsack(id + 1, recursosS - W[id]));//maximo entre tomar y no tomar
        return dp[id][recursosS];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            W = new int[N];
            P = new int[N];
            n = N;
            int m1 = 0, s, m2 = 0;
            for (int j = 0; j < N; j++) {
                s = sc.nextInt();
                P[j] = s;
                W[j] = sc.nextInt();
            }
            int G = sc.nextInt();
            int[] g = new int[G];
            for (int j = 0; j < G; j++) {
                //m1 += k;
                g[j] = sc.nextInt();
                m2 += g[j];
            }
            dp = new int[n][m2 + 1];
            for (int j = 0; j < G; j++) {
                int k = knapsack(0, g[j]);
                m1 += k;
            }
            System.out.println(m1);
        }
    }
}