package UVa.SmallFactors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        ArrayList<Double> l2 = new ArrayList();
        ArrayList<Double> l3 = new ArrayList();
        ArrayList<Integer> lf = new ArrayList();
        for (int i = 0; i < 31; i++) {
            l2.add((Math.pow(2, i)));
        }
        for (int i = 0; i < 20; i++) {
            l3.add(Math.pow(3, i));
        }
        for (int i = 0; i < 20; i++) {
            Double y = l3.get(i);
            for (int j = 0; j < 31; j++) {
                Double p = l2.get(j);
                if (y * p <= Integer.MAX_VALUE) {
                    lf.add(new Double(y * p).intValue());
                }
            }
        }
        Collections.sort(lf);
        while ((s = br.readLine()) != null) {
            Integer h = new Integer(s);
            if (h == 0) {
                break;
            } else {
                int o = 0;
                int q = 0;
                while (q < h) {
                    if (o >= 620) {
                        q = lf.get(o - 1);
                        break;
                    } else {

                        q = lf.get(o);
                    }
                    o++;
                }
                System.out.println(lf.get(o-1));
            }
        }
    }
}