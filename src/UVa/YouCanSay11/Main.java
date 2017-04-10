package UVa.YouCanSay11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) throws IOException {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((s=br.readLine())!=null){
            if(s.equals("0")){
                break;
            }
            else{
                BigInteger t = new BigInteger(s);
                BigInteger o = t.remainder(new BigInteger("11"));
                if(o.compareTo(BigInteger.ZERO) == 0){
                    System.out.println(t.toString()+" is a multiple of 11.");
                }
                else{
                    System.out.println(t.toString()+" is not a multiple of 11.");
                }
            }
        }
    }
}