package UVa.TheBusDriverProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (n == 0 &&  d == 0 && r == 0) {
                break;
            }
            ArrayList<Integer> morning = new ArrayList<Integer>();
            ArrayList<Integer> nigth = new ArrayList<Integer>();
            StringTokenizer sc = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                morning.add(Integer.parseInt(sc.nextToken()));
            }
            sc = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nigth.add(Integer.parseInt(sc.nextToken()));
            }
            Collections.sort(morning);
            Collections.sort(nigth);
            int m = 0;
            int t = 0;
            for (int i = 0; i < n; i++) {
                m = morning.get(i) + nigth.get(n - 1 - i);
                if (m > d) {
                    t += (m - d) * r;
                }
            }
            System.out.println(t);
        }
    }
}