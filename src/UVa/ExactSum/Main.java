package UVa.ExactSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            Integer N = new Integer(s);
            Integer[] arr = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            TreeSet<Integer> ts = new TreeSet<Integer>();
            for (int i = 0; i < N; i++) {
                Integer j = (Integer.parseInt(st.nextToken()));
                arr[i] = j;
                ts.add(j);
            }
            Integer M = new Integer(br.readLine());
            Arrays.sort(arr);
            br.readLine();
            int y = 0;
            int r = 0;
            Integer d = Integer.MAX_VALUE;
            for (int p = 0; p < N; p++) {
                if (!ts.contains(M - arr[p])) {
                    continue;
                } else {
                    if (Math.abs((M - arr[p]) - arr[p]) < d) {
                        d = Math.abs((M - arr[p]) - arr[p]);
                        r = arr[p];
                        y = (M - arr[p]);
                    }
                }
            }
            sb.append("Peter should buy books whose prices are " + r + " and " + y + ".\n\n");
        }
        System.out.print(sb);
    }
}