package Simplifying_Fractions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        s = br.readLine();
        Integer c = new Integer(s);
        for(int i=0;i<c.intValue();i++){
            s = br.readLine();
            st = new StringTokenizer(s,"/");
            BigInteger p = new BigInteger(st.nextToken().trim());
            BigInteger q = new BigInteger(st.nextToken().trim());
            BigInteger g = p.gcd(q);
            p = p.divide(g);
            q = q.divide(g);
            System.out.println(p+" / "+q);
        }        
    }
}