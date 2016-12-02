package N_NodN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int NOD(int x) {

        int nDiv = 1;
        for (int p = 2; p * p <= x; ++p) {
            int cnt = 0;
            while (x % p == 0) {
                ++cnt;
                x /= p;
            }
            nDiv *= cnt + 1;
        }
        if (x > 1) {
            nDiv *= 2;
        }
        return nDiv;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = new int[64725];
        arr[0] = 1;
        for (int i = 1; i < 64725; i++) {
            arr[i] = arr[i - 1] + NOD(arr[i - 1]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        tm.put(0, 0);
        for (int i = 0; i < arr.length; i++) {
            tm.put(arr[i], i + 1);
        }
        for (int c = 0; c < T; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int t = tm.get(tm.floorKey(B)) - tm.get(tm.lowerKey(A));
            sb.append("Case ");
            sb.append(c + 1);
            sb.append(": ");
            sb.append(t);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}