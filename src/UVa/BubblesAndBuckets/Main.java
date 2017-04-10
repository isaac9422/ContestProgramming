package UVa.BubblesAndBuckets;

import java.util.Scanner;

public class Main {

    static int size = 500000;
    static int INF = 1000000000;
    static int[] A = new int[size + 2];
    static int[] I = new int[size + 2];
    static int[] D = new int[size + 2];
    static int cont;

    static void merge(int p, int q, int r) {
        int i, j, k, indI, indD;

        for (i = p, indI = 1; i <= q; i++) {
            //long lp  
            I[indI++] = A[i];
        }
        I[indI] = INF;

        for (i = q + 1, indD = 1; i <= r; i++) {
            D[indD++] = A[i];
        }
        D[indD] = INF;

        i = j = 1;

        for (k = p; k <= r; k++) {
            if (I[i] > D[j]) {
                cont += indI - i;
                A[k] = D[j];
                j++;
            } else {
                A[k] = I[i];
                i++;
            }
        }
    }

    static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            if(n==0){
                break;
            }
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            cont = 0;
            mergeSort(1,n);
            if((cont%2)==1){
                System.out.println("Marcelo");
            }
            else{
                System.out.println("Carlos");
            }
        }
    }
}