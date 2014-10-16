package StationBalance;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            if(flag){
                flag = false;
            }
            else{
                sb.append("\n");
            }
            int C, S;
            test++;
            C = sc.nextInt();
            S = sc.nextInt();
            if (C == 0) {
                break;
            }
            int[] t = new int[2 * C];
            int l;
            for (int i = 0; i < S; i++) {
                l = sc.nextInt();
                t[i] = l;
            }
            for (int i = S; i < 2 * C; i++) {
                t[i] = 0;
            }
            Arrays.sort(t);
            //System.out.println(Arrays.toString(t));
            int[][] ans = new int[C][2];
            for (int is = 0; is < C; is++) {
                ans[is][0] = t[is];
                ans[is][1] = t[2*C - is - 1];

            }
            sb.append("Set #");
            sb.append(test);
            sb.append("\n");
            //System.out.printf("Set #%d\n", test);
            for (int i = 0; i < C; i++) {
                //I += Math.abs(ans[i][0] + ans[i][1] - p);
                sb.append(" ");
                sb.append(i);
                sb.append(":");
                //System.out.printf("%d:", i);
                if (ans[i][0] != 0) {
                    sb.append(" ");
                    sb.append(ans[i][0]);
                    sb.append(" ");
                    sb.append(ans[i][1]);
                    sb.append("\n");
                    //System.out.printf(" %d %d\n", ans[i][0], ans[i][1]);
                } else if (ans[i][1] != 0) {
                    sb.append(" ");
                    sb.append(ans[i][1]);
                    sb.append("\n");
                    //System.out.printf(" %d\n", ans[i][1]);
                } else {
                    sb.append("\n");
//                    System.out.printf("\n");
                }
            }
            double A, imbalance;
            imbalance = 0;
            A = 0;
            for (int i = 0; i < 2 * C; i++) {
                A = A + t[i];
            }
            A = A / C;
            double x = 0;
            for (int i = 0; i < C; i++) {
                x = ans[i][0] + ans[i][1] - A;
                if (x < 0) {
                    x = x * -1;
                }
                imbalance = imbalance + x;
            }
            DecimalFormat df = new DecimalFormat("######.000000");
            
            String str = df.format(imbalance);
            str = str.replace(",", ".");
            str = str.substring(0, str.length()-1);
            sb.append("IMBALANCE = ");
            sb.append(str);
            sb.append("\n");
            //sb.append("\n");
//            System.out.println("IMBALANCE = " + str);
            //          System.out.printf("\n");
        }
        System.out.print(sb);
    }
}