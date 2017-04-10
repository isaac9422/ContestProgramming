package UVa.CamelTrading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long minm(String g){
        if(!g.contains("+") && !g.contains("*")){
            return Long.parseLong(g);
        }
        else if(g.contains("*")){
            return minm(g.substring(0, g.indexOf("*"))) * minm(g.substring(g.indexOf("*")+1, g.length()));
        }
        else{
            return minm(g.substring(0, g.indexOf("+"))) + minm(g.substring(g.indexOf("+")+1, g.length()));
        }
    }
    public static long maxm(String g){
        if(!g.contains("+") && !g.contains("*")){
            return Long.parseLong(g);
        }
        else if(g.contains("+")){
            return maxm(g.substring(0, g.indexOf("+"))) + maxm(g.substring(g.indexOf("+")+1, g.length()));
        }
        else{
            return maxm(g.substring(0, g.indexOf("*"))) * maxm(g.substring(g.indexOf("*")+1, g.length()));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0;n<N;n++){
            String s = br.readLine();
            s = s.trim();
            long max = minm(s);
            long min = maxm(s);
            System.out.println("The maximum and minimum are "+max+" and "+min+".");
        }
    }
}