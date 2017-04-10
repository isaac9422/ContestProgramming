package UVa.OddRootSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<Integer, Long> hm = new HashMap<Integer, Long>();

    public static void calculo(int m) {
        int y = 1;
        int g = 2;
        int f = 1;
        int c = 0;
        long s = 0;
        for (int i = 1; i <= m; i += 2) {
            c++;
            s+=y;
            s%=100000000;
            hm.put(i, s);
            if (c == g) {
                f*=-1;
                if (f == 1) {
                    g += 2;
                }
                c = 0;
                y++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String s;
        ArrayList<Integer> al = new ArrayList<Integer>();
        Integer m = Integer.MIN_VALUE;
        Integer v;
        //while ((v=sc.nextInt())!=0) {
        while(!(s=br.readLine()).equals("0")){
            v = Integer.parseInt(s);
            v+=0;
            al.add(v);
            if (v > m) {
                m = v;
            }
        }
        calculo(m);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) % 2 == 1) {
                sb.append(hm.get(al.get(i)) + "\n");
            } else {
                sb.append(hm.get(al.get(i) - 1) + "\n");
            }
        }
        System.out.print(sb);
    }
}