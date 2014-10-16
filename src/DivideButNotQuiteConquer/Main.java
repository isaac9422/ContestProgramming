package DivideButNotQuiteConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s);
            Integer n = new Integer(st.nextToken());
            Integer m = new Integer(st.nextToken());
            Double d = Math.log(n) / Math.log(m);
            StringBuilder sb = new StringBuilder();
            if(d.floatValue() - d.intValue() != 0 || m<= 1 || n <= 1){
                sb.append("Boring!");
            }
            else{
                sb.append(n);
                while(n>1){
                    n/=m;
                    sb.append(" "+n);
                }
            }
            System.out.println(sb);
        }
    }
    static int[] getBoo(int x, int m) {
        if(x<=1 || m<=1)
            return new int[0];
        LinkedList<Integer> list = new LinkedList<Integer>();
        boolean flag = true;
        int temp = x;
        while (temp > 1) {
            list.add(temp);
            if (temp % m == 0) {
                temp /= m;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            list.add(1);
            int arr[] = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        } else {
            return new int[0];
        }
    }
}