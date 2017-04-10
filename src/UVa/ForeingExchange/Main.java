package UVa.ForeingExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        while (true) {
            int cases = Integer.parseInt(br.readLine());
            if (cases == 0) {
                break;
            }
            int []arrX=new int[cases];
            int []arrY=new int[cases];
            for (int i = 0; i < cases; i++) {
                String [] str=br.readLine().split(" ");
                arrX[i]=Integer.parseInt(str[0]);
                arrY[i]=Integer.parseInt(str[1]);
            }
            Arrays.sort(arrX);
            Arrays.sort(arrY);
            boolean ok=true;
            for(int i=0;i<cases;i++){
                if(arrX[i]!=arrY[i]){
                    ok=false;
                    break;
                }
            }
            if(ok){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}
