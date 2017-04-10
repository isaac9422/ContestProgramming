package UVa.TheMonkeyAndTheOiledBamboo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Integer T = new Integer(br.readLine());
        for (int c = 0; c < T; c++) {
            Integer n = new Integer(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[n + 1];
            arr[0] = 0;
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.valueOf(st.nextToken());
            }
            int k = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                int dx = arr[i] - arr[i - 1];
                if (dx > k) {
                    k = dx;
                }
            }
            int p = k;
            boolean flag = false;
            for (int t = 1; t <= n; t++) {
                int dx = arr[t] - arr[t - 1];
                if (dx == k) {
                    k--;
                } else if(dx>k) {
                    p++;
                    break;
                }
            }
            System.out.println("Case " + (c + 1) + ": " + p);
        }
    }
}