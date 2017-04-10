package UVa.FindTheTelephone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            char[] g = s.toCharArray();
            for (int i = 0; i < g.length; i++) {
                if (g[i] == 'A' || g[i] == 'B' || g[i] == 'C') {
                    sb.append("2");
                } else if (g[i] == 'D' || g[i] == 'E' || g[i] == 'F') {
                    sb.append("3");
                } else if (g[i] == 'G' || g[i] == 'H' || g[i] == 'I') {
                    sb.append("4");
                } else if (g[i] == 'J' || g[i] == 'K' || g[i] == 'L') {
                    sb.append("5");
                } else if (g[i] == 'M' || g[i] == 'N' || g[i] == 'O') {
                    sb.append("6");
                } else if (g[i] == 'P' || g[i] == 'Q' || g[i] == 'R' || g[i] == 'S') {
                    sb.append("7");
                } else if (g[i] == 'T' || g[i] == 'V' || g[i] == 'U') {
                    sb.append("8");
                } else if (g[i] == 'W' || g[i] == 'X' || g[i] == 'Z' || g[i] == 'Y') {
                    sb.append("9");
                } else {
                    sb.append(g[i]);
                }
            }
         System.out.println(sb);
        }
    }
}