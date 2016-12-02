package Football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int a,b,sum =0;
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if(a-b>0){
                    sum+=3;
                }
                else{
                    al.add(b-a);
                }
            }
            int i=0;
            Collections.sort(al);
            while(g>=0 ){
                if(i == al.size()){
                    break;
                }
                else if(g>al.get(i)){
                    sum+=3;
                    g-=al.get(i)+1;
                }
                else if(g==al.get(i)){
                    sum+=1;
                    g-=al.get(i);
                }
                i++;
            }
            System.out.println(sum);
        }
    }
}