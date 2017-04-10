/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google.CodeJam17.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author jhunior
 */
public class A {

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int x = 1; x <= T; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
//            int k = (s.length() > 10) ? ThreadLocalRandom.current().nextInt(2, 10)
//                    : ThreadLocalRandom.current().nextInt(2, s.length() + 1);
//            System.out.println("==>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//            int er = ThreadLocalRandom.current().nextInt(1, 11);
//            StringBuilder sb = new StringBuilder();
//            for(int i=0;i<er;i++){
//                sb.append(s);
//            }
//            s = sb.toString();
//            System.out.println(s + " " + k);
//            System.out.println("");

            int y = flipPancakes(s.toCharArray(), k);
            if (y == -1) {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + x + ": " + y);
            }
//            System.out.println("===================C========================");
        }
    }

    private static int flipPancakes(char[] c, int k) {
        int r = 0;
        for (int i = c.length - 1; i >= k - 1; i--) {
            if (c[i] == '-') {
                r++;
                for (int j = i - (k - 1); j <= i; j++) {
                    c[j] = flip(c[j]);
                }
            }
        }
        for (int i = 0; i < k - 1 && r >= 0; i++) {
            if (c[i] == '-') {
                r = -1;
            }
        }
        return r;
    }

    private static char flip(char c) {
        switch (c) {
            case '-':
                return '+';
            case '+':
                return '-';
            default:
                return ' ';
        }
    }

}
/*
 4
 ---+-++- 3
 +++++ 4
 -+-+- 4
 -++++++++++++++- 2

 ===================
 ---+-++- 3

 ---+---+
 ---+++++
 ++++++++	
 ===================
 -++ 2

 IMPOSSIBLE
 ===================
 ++- 2

 IMPOSSIBLE
 ===================
 -++++++++++++++- 2

 -+++++++++++++-+
 -++++++++++++-++
 -+++++++++++-+++
 -++++++++++-++++
 -+++++++++-+++++
 -++++++++-++++++
 -+++++++-+++++++
 -++++++-++++++++
 -+++++-+++++++++
 -++++-++++++++++
 -+++-+++++++++++
 -++-++++++++++++
 -+-+++++++++++++
 --++++++++++++++
 ++++++++++++++++
 15
 ===================
 ---+-++- 2

 ---+-+-+
 --+--+-+
 -+---+-+
 -+++-+-+
 -+---+-+
 */
