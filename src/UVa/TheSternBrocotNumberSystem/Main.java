package UVa.TheSternBrocotNumberSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            StringBuilder sb = new StringBuilder();
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 1 && n == 1) {
                break;
            } else {
                double dm = m;
                double dn = n;
                double mi = 0;
                double ni = 1;
                double md = 1;
                double nd = 0;
                double mp = 1;
                double np = 1;
                double dv = dm / dn;
                double dp;
                while (!(mp == m && np == n)) {
                    dp = mp / np;
                    if (dv > dp) {
                        sb.append("R");
                        ni = np;
                        mi = mp;
                        mp += md;
                        np += nd;
                    } else {// if (m/n < mp/np){
                        sb.append("L");
                        nd = np;
                        md = mp;
                        mp += mi;
                        np += ni;
                    }
                }
            }
            System.out.println(sb);
        }
    }
}