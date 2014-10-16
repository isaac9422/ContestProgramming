package PrimeWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static HashSet<Integer> hs = new HashSet();

    public static void criba() {
        int n = 52 * 20;
        HashMap<Integer, Boolean> hm = new HashMap();
        hm.put(0, true);
        hm.put(1, false);
        hs.add(1);
        for (int i = 2; i <= n; i++) {
            hm.put(i, false);
        }
        for (int i = 2; i < Math.floor(n); i++) {
            if (hm.get(i) == false) {
                hs.add(Integer.valueOf(i));
                int k = n / i;
                for (int j = i; j <= k; j++) {
                    int y = j * i;
                    hm.remove(y);
                    hm.put(y, true);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        criba();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            Integer sum = new Integer("0");
            int k = 0;
            for (int i = 0; i < s.length(); i++) {
                if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) {
                    k = (int) s.charAt(i) - (65 - 27);
                }
                if ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122) {
                    k = (int) s.charAt(i) - (97 - 1);
                }
                sum += k;
            }
            boolean y = hs.contains(sum);
            if (y) {
                sb.append("It is a prime word.");
            } else {
                sb.append("It is not a prime word.");
            }
        }
        System.out.println(sb);
    }
}