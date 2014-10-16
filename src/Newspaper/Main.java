package Newspaper;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
            String a;
            int p;
            for (int j = 0; j < k; j++) {
                a = sc.nextLine();
                p = sc.nextInt();
                ht.put(a, p);
            }
            int m = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int l = 0; l < m; l++) {
                sb.append(sc.nextLine());
            }
            //sb.
        }
    }

}
