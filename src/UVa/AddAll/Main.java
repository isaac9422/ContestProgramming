package UVa.AddAll;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            int r = 0;
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(N);
            for (int i = 0; i < N; i++) {
                q.add(sc.nextInt());
            }
            while (!q.isEmpty()) {
                int a = q.poll();
                int b = q.poll();
                r += a+b;
                q.add(a+b);
                if(q.size() == 1){
                    break;
                }
            }
            System.out.println(r);
        }
    }
}