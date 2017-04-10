package UVa.IfWeWereAChildAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            BigInteger big = new BigInteger(st.nextToken());
            String g = st.nextToken();
            BigInteger bigg = new BigInteger(st.nextToken());
            BigInteger  j = null;
            if(g.equals("%")) {
                j = big.mod(bigg);
            }
            if (g.equals("/")) {
                j = big.divide(bigg);
            }
            System.out.println(j);
        }
    }
}