package DoYourOwnHomework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = new Integer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=T;i++){
            Integer N = new Integer(br.readLine());
            HashMap<String, Integer> hm = new HashMap<String,Integer>();
            for(int j=0;j<N;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String g = st.nextToken();
                Integer k = new Integer(st.nextToken());
                hm.put(g, k);
            }
            Integer D = new Integer(br.readLine());
            String l = br.readLine();
            sb.append("Case "+i+": ");
            if(hm.containsKey(l)){
                Integer p = hm.get(l);
                if(p<=D){
                    sb.append("Yesss\n");
                }
                else if(p>D && p<=(D+5)){
                    sb.append("Late\n");
                }
                else{
                    sb.append("Do your own homework!\n");
                }
            }
            else{
                sb.append("Do your own homework!\n");
            }
        }
        System.out.print(sb);
    }
}