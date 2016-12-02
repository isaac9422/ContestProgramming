package NewRuleInEuphomia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    private static TreeSet<Long> hs = new TreeSet<Long>();
    private static ArrayList<Long> arr = new ArrayList<Long>();

    public static void criba() {
        int n = 1000000;
        HashMap<Long, Boolean> hm = new HashMap<Long,Boolean>();
        hm.put(0l, true);
        hm.put(1l, true);
        //int q = 0;
        hs.add(1l);
        for (long i = 2; i <= n+1; i++) {
            hm.put(i, false);
        }
        for (long i = 2; i <= n+1; i++) {
            if (hm.get(i) == false) {
                arr.add(i);
                hs.add(i);
                for (long j = i * i; j <= n+1; j+=i) {
                    hm.put(j, true);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        criba();
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String s;
        int cas = 0;
        //while ((s = br.readLine()) != null) {
        while(sc.hasNext()){
            long n = sc.nextLong();//Long.parseLong(sc.nextLine());
            if (n == 0) {
                break;
            } else {
                cas++;
                long b = hs.lower(n);
                int i = 0;
                long sum = 0;
                while(arr.get(i)<n){
                    
                    if(arr.get(i) + b <= n){
                        sum += hs.subSet(arr.get(i), false, b, true).size();
                        i++;
                    }else{
                        b = hs.floor(n - arr.get(i));
                        if(b<=arr.get(i)){
                            break;
                        }
                    }
                }
                System.out.println("Case " + cas + ": " + sum);
            }
        }
    }
}