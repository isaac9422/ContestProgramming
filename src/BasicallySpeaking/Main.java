package BasicallySpeaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            if (s.equals("0")) {
                break;
            }
            StringBuilder r = new StringBuilder();
            StringTokenizer st = new StringTokenizer(s);
            String h = st.nextToken();
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(h, f);
            r.append(Integer.toString(b, t));
            if (r.length() > 7) {
                sb.append("  ERROR");
            } else {
                for (int i = 0; i < 7 - r.length(); i++) {
                    sb.append(" ");
                }
                for(int i=0;i<r.length();i++){
                    if(r.charAt(i)=='a'){
                        r.replace(i, i+1, "A");
                    }
                    else if(r.charAt(i)=='b'){
                        r.replace(i, i+1, "B");
                    }
                    else if(r.charAt(i)=='c'){
                        r.replace(i, i+1, "C");
                    }
                    else if(r.charAt(i)=='d'){
                        r.replace(i, i+1, "D");
                    }
                    else if(r.charAt(i)=='e'){
                        r.replace(i, i+1, "E");
                    }
                    else if(r.charAt(i)=='f'){
                        r.replace(i, i+1, "F");
                    }
                }
                sb.append(r);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}