package UVa.ErrorConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            if (Integer.parseInt(s) == 0) {
                break;
            } else {
                Integer n = Integer.parseInt(s);
                int[][] m = new int[n][n];
                int p =0, l = 0,f,c,as=0,sa=0;
                for (int i = 0; i < n; i++) {
                    String[] t = (br.readLine()).split(" ");
                    for(int j=0;j<n;j++){
                        m[i][j] = Integer.parseInt(t[j]);
                    }
                }
                for(int i=0;i<n;i++){
                    f=0;
                    for(int j=0;j<n;j++){
                        f+=m[i][j];
                    }
                    if(f%2 != 0){
                        p++;
                        as = i;
                    }
                }
                for(int j=0;j<n;j++){
                    c=0;
                    for(int i=0;i<n;i++){
                        c+=m[i][j];
                    }
                    if(c%2 != 0){
                        l++;
                        sa = j;
                    }
                }
                if(p == 0 && l==0){
                    System.out.println("OK");
                }
                else if(p == 1 || l==1){
                    System.out.println("Change bit ("+(as+1)+","+(sa+1)+")");
                }
                else{
                    System.out.println("Corrupt");
                }
                
            }
        }
    }
}