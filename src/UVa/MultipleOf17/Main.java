package UVa.MultipleOf17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String s;
           while((s=br.readLine())!=null){
               BigInteger big = new BigInteger(s);
               if(big.toString().equals("0")){
                   break;
               }
               else{
                   BigInteger j = big.mod(new BigInteger("17"));
                   if(j.compareTo(BigInteger.ZERO)==0)
                      System.out.println(1);
                   else
                      System.out.println(0); 
               }
           }
           br.close();
           System.exit(0);
    }
}