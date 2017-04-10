package UVa.ThePlayBoyChimp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = new Integer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int i = 0; i < N; i++) {
            ts.add(new Integer(st.nextToken()));
        }
        Integer Q = new Integer(br.readLine());
        StringTokenizer so = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            Integer k = new Integer(so.nextToken());
            if (k <= ts.first()) {
                System.out.println("X " + ts.higher(k));
            } else if (k >= ts.last()) {
                System.out.println(ts.lower(k) + " X");
            } else {
                System.out.println(ts.lower(k)+" "+ts.higher(k));
            }
        }
    }
}