package UVa.JoannaAndTheOddNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException  {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((s=br.readLine())!=null){
            Integer t = new Integer(s);
            t = 3 * ((t*(t+2))/2) - 6;
            System.out.println(t);
        }
    }
}