/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Jhunior
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int a = Integer.parseInt(s);
            int b = Integer.parseInt(br.readLine());
            int ty[] = new int[b];
            while (b-- > 0) {
                int y = Integer.parseInt(br.readLine());
                ty[ty.length - b - 1] = y;
            }
            int maxx = 0, posMax = 0, posIni = 0;
            for (int i = 0; i < ty.length - 1; i++) {
                int current = Arrays.binarySearch(ty, ty[i] + a - 1);
                for(int j=current+1;j<ty.length -1 && current>0;j++){
                    if(ty[j] == ty[i]+a-1){
                        current++;
                    }else{
                        break;
                    }
                }
                if (maxx < current - i +1) {                    
                    maxx = current - i +1;
                    posIni = i;
                    posMax = current - 1;
                }
            }
            System.out.println(maxx + " " + ty[posIni] + " " + ty[(posMax)]);
        }
    }
}
/***
 * 
5
20
1
2
3
6
8
12
13
13
15
16
17
18
19
20
20
21
25
26
30
31
 */