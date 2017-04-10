package UVa.AgeSort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        boolean flag=true;
        while (true) {
           
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            if(!flag)
                sb.append("\n");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            for (int i = 0; i < num; i++) {
                if (i > 0) {
                    sb.append(" ");
                }
                sb.append(arr[i]);
            }
            flag=false;
        }
        System.out.println(sb);
    }
}
