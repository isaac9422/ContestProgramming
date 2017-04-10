package UVa.TheJackPot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        while ((N = sc.nextInt()) != 0) {
            int x, t = 0, maxx = 0;
            for (int i = 0; i < N; i++) {
                x = sc.nextInt();
                t += x;
                maxx = Math.max(maxx, t);
                if (t < 0) {
                    t = 0;
                }
            }
            if (maxx > 0) {
                System.out.println("The maximum winning streak is " + maxx + ".");
            } else {
                System.out.println("Losing streak.");
            }
        }

    }
}