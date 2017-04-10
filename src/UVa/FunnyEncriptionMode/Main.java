package UVa.FunnyEncriptionMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Integer c = new Integer(br.readLine());
        for(int i=0;i<c;i++){
            String b,h;
            int b1 = 0, b2 = 0;
            Integer t = new Integer(br.readLine());
            b = Integer.toBinaryString(t);
            h = Integer.toBinaryString(Integer.parseInt(t.toString(),16));
            b1 = b.length();
            b2 = h.length();
            b = b.replaceAll("1", "");            
            h = h.replaceAll("1", "");
            b1 -= b.length();            
            b2 -= h.length();
            System.out.println(b1+" "+b2);
        }
    }
}