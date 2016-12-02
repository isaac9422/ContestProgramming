package BoiledEggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n,P,Q;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            ArrayList<Integer> al = new ArrayList<Integer>();
            int i =0;
            String[] op = br.readLine().split(" ");
            int con = 0;
            while(al.size()<P && con<Q && i<op.length){
                con+=Integer.parseInt(op[i]);
                if(con>Q){
                    break;
                }
                al.add(Integer.parseInt(op[i]));
                i++;
            }
            System.out.println("Case "+(t+1)+": "+al.size());
        }
    }
}