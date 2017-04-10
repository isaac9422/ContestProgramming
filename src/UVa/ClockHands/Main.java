package UVa.ClockHands;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            String[] p = s.split(":");
            int h = new Integer(p[0]).intValue();
            int m = new Integer(p[1]).intValue();
            if(h == 0 && m == 0){
                break;
            }
            else{
                Double g = ((h*30)+(m*0.5))-(m*6);
                DecimalFormat df = new DecimalFormat("0.000");
                Float ans = Math.abs(g.floatValue());
                ans = Math.min(360-g.floatValue(), g.floatValue());
                    System.out.println(df.format(ans));
            }
        }
    }
}