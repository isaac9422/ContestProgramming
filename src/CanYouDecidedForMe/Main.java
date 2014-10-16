package CanYouDecidedForMe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Integer c = new Integer(br.readLine());
        for (int i = 0; i < c; i++) {
            s = br.readLine();
            boolean flag = false;
            String t = new String(s);
            int m = t.indexOf("M");
            int e = t.indexOf("E");
            if (m < e - 1) {
                t = t.replaceFirst("M", " ");
                t = t.replaceFirst("E", " ");
                StringTokenizer st = new StringTokenizer(t);
                int h = s.length() - t.length();
                if (h > 2) {
                    flag = true;
                } else {
                    boolean flag1 = true, flag2 = false, flag3 = false;
                    int mm = 0,ee = 0,aa = 0;
                    while (st.hasMoreTokens()) {
                        int con = 0;
                        String sd = st.nextToken();
                        for (int u = 0; u < sd.length(); u++) {
                            if (sd.charAt(u) == '?') {
                                con++;
                            }
                        }
                        if(con<sd.length()){
                            flag = true;
                        }else{
                            if(flag3){
                                aa = con;
                            }
                            if(flag2){
                                ee = con;
                                flag2 = false;
                                flag3 = true;
                            }
                            if(flag1){
                                mm = con;
                                flag1 = false;
                                flag2 = true; 
                            }
                        }
                    }
                    if(((mm+ee) < aa)||((mm+ee) > aa)){
                        flag = true;
                    }
                }
            } else {
                flag = true;
            }

            if (flag) {
                System.out.println("no-theorem");
            } else {
                System.out.println("theorem");
            }
        }
    }
}