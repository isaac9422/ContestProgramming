package UVa.Division_of_Nlogonia;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer tk;
        while((s=br.readLine())!=null){
            Integer t = new Integer(s);
            if(t==0){
                break;
            }
            else{
                tk = new StringTokenizer(br.readLine());
                int dx = new Integer(tk.nextToken()).intValue();
                int dy = new Integer(tk.nextToken()).intValue();
                for(int i=0;i<t;i++){
                    boolean div = false;
                    boolean x = false;
                    boolean y = false;
                    s = br.readLine();
                    tk = new StringTokenizer(s);
                    int cx = new Integer(tk.nextToken()).intValue();
                    int cy = new Integer(tk.nextToken()).intValue();
                    if(cx == dx || cy == dy){
                        div = true;
                    }
                    if(cx>dx){
                        x = true;
                    }
                    if(cy>dy){
                        y = true;
                    }
                    if(div==true){
                        System.out.println("divisa");
                    }
                    else{
                        if(x==true){
                            if(y==true){
                                System.out.println("NE");
                            }
                            else{
                                System.out.println("SE");
                            }
                        }
                        else{
                            if(y==true){
                                System.out.println("NO");
                            }
                            else{
                                System.out.println("SO");
                            }
                        }
                    }
                }
            }
        }
    }
}