package SubstitutionCypher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Integer C = new Integer(br.readLine());
        for (int c = 0; c < C; c++) {
            if (c != 0) {
                System.out.println("");
            }else{
            br.readLine();}
            StringBuilder sb = new StringBuilder();
            Hashtable<Character, Character> ht = new Hashtable<Character, Character>();
            String a = br.readLine();
            String p = br.readLine();
            for (int i = 0; i < a.length(); i++) {
                ht.put(a.charAt(i), p.charAt(i));
            }
            sb.append(p + "\n");
            sb.append(a + "\n");
            try {
                while (!(s = br.readLine()).equals("")) {
                    char[] t = s.toCharArray();
                    for (int i = 0; i < t.length; i++) {
                        if (ht.containsKey(t[i])) {
                            sb.append(ht.get(t[i]));
                        } else {
                            sb.append(t[i]);
                        }
                    }
                    sb.append("\n");
                }
            } catch (Exception e) {
            }
        System.out.print(sb);
        }
    }
}