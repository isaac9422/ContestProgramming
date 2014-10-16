package Cateximoluj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i =0;
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n==0){
                break;
            }
            i++;
            int M = 100, T= 100000, X = 1000, C = 10000000;
            int m,t,x,c,r;
            c = n / C;
            n %=C;
            t = n / T;
            n %=T;
            x = n / X;
            n %=X;
            m = n / M;
            n %=M;
            r = n;
            StringBuilder sb = new StringBuilder();
            if(c!=0){
                sb.append(" ");
                sb.append(c);
                sb.append(" caluj");
            }
            if(t!=0){
                sb.append(" ");
                sb.append(t);
                sb.append(" teluj");
            }
            if(x!=0){
                sb.append(" ");
                sb.append(x);
                sb.append(" xiluj");
            }
            if(m!=0){
                sb.append(" ");
                sb.append(m);
                sb.append(" moluj");
            }
            if(r!=0){
                sb.append(" ");
                sb.append(r);
            }
            System.out.println(i+"."+sb);
        }
    }
}