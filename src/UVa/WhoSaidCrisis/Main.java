package UVa.WhoSaidCrisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Integer c = new Integer(br.readLine());
        for(int i=0;i<c;i++){
               StringTokenizer st = new StringTokenizer(br.readLine());
               BigInteger A = new BigInteger(st.nextToken());
               BigInteger B = new BigInteger(st.nextToken());
               System.out.println(A.subtract(B));
        }
    }
}