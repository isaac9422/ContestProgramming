package UVa.AllinAll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while((in=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(in);
            String s = st.nextToken();
            String t = st.nextToken();
            int i=0;
            int j=0;
            while(j<t.length()){
                if(s.charAt(i) == t.charAt(j)){
                    i++;
                    if(i==s.length()){
                        break;
                    }
                }
                j++;
            }
            if(i==s.length()){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}