package WhatCryptanalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        HashMap hs = new HashMap();
        for (int i = 0; i < c; i++) {
            s = br.readLine();
            s = s.toUpperCase();
            for (char l = 'A'; l <= 'Z'; l++) {
                String t = new String(s);
                s = s.replaceAll(String.valueOf(l), "");
                int d = t.length() - s.length();
                if (d > 0) {
                    if (hs.containsKey(l)) {
                        Integer g = (Integer) hs.get(l);
                        hs.put(l, d + g);
                    } else {
                        hs.put(l, d);
                    }
                }
            }
        }
        ArrayList al = new ArrayList();
        for (char l = 'A'; l <= 'Z'; l++) {
            if (hs.containsKey(l)) {
                al.add(hs.get(l));
            }
        }
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        while (!(al.isEmpty())) {
            Integer y = (Integer) al.remove(al.size() - 1);
            for (char l = 'A'; l <= 'Z'; l++) {
                if (hs.get(l) == y) {
                    if (al.size() == 0) {
                        sb.append(String.valueOf(l) + " " + y.toString());
                    } else {
                        sb.append(String.valueOf(l) + " " + y.toString() + "\n");
                    }
                    hs.remove(l);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}