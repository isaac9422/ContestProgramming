package UVa.ShoemakersProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main  {
    public static class work implements Comparable<work>{
        int id;
        double t;
        work(int i, double t){
            this.id = i;
            this.t = t;
        }
        
        public int id(){
            return this.id;
        }
        
        @Override
        public int compareTo(work o) {
            if (o == null) {
                return -1;
            }
            int r = Double.compare(o.t, t);
            if (r != 0) {
                return r;
            } else {
                if (id < o.id) {
                    return -1;
                } else if (id > o.id) {
                    return 1;
                }
            } 
            return 0;
        }        
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            br.readLine();
            int N = Integer.parseInt(br.readLine());
            ArrayList<work> al = new ArrayList<work>();
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                double l = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                al.add(new work(i, w/l)); 
            }
            Collections.sort(al);
            if(c!=0){
                System.out.println("");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(al.get(0).id + 1);
            for(int i=1;i<N;i++){
                sb.append(" ");
                sb.append(al.get(i).id+1);
            }
            System.out.println(sb);
        }
    }
}