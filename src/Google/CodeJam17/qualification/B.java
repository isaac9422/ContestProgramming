/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google.CodeJam17.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author jhunior
 */
public class B {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int x=1;x<=T;x++){
            long N = Long.parseLong(br.readLine());
            long y;
            if(N==10){
                y = 9;
            }else if(N < 20){
                y = N;
            }else{
                y = tidy(N);
            }
            System.out.println("Case #"+x+": "+y);
        }
    }
   
    public static long tidy(long N){
        char[] s = String.valueOf(N).toCharArray();
        StringBuilder r = new StringBuilder();
        boolean conversion = false;
        for(int i=0;i<s.length-1;i++){
            if(!conversion){
                if(s[i]> s[i+1]){                    
                    r.append(precendingNumber(s[i]));
                    conversion=true;
                }else{
                    r.append(s[i]);
                }
            }else{
                r.append("9");
            }
        }
        if(conversion){
            r.append("9");
            return tidy(Long.parseLong(r.toString()));
        }else{
            r.append(s[s.length-1]);
            return Long.parseLong(r.toString());
        }
    }

    private static String precendingNumber(char s) {
        switch(s){
            case '1': return "0";
            case '2': return "1";
            case '3': return "2";
            case '4': return "3";
            case '5': return "4";
            case '6': return "5";
            case '7': return "6";
            case '8': return "7";
            case '9': return "8";
            default: return "";
        }
    }
    
}
/*
12345673

12345669
=========================
1000

0999

=========================
813

799
=========================
123456289

123455999
=========================
123456089


=========================
22

19
=========================
12528354689

12499999999
=========================
12499999999

124
=========================
31903

=========================
11000

10999
09999
==========================
22000

21999
19999
==========================
112330

112329
112199
111999
==========================
111111111111111110

111111111111111109
111111111111111099
111111111111110999
111111111111109999
111111111111099999
111111111110999999
111111111109999999
111111111099999999
111111110999999999
111111109999999999
111111099999999999
111110999999999999
111109999999999999
111099999999999999
110999999999999999
109999999999999>999
099999999999999999

*/