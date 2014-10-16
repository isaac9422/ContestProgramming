package AllRoadsLeadWhere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<String> vt = new ArrayList<String>();
    public static HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

    public static String BFS(String g, String h) {
        HashMap<String,String> r = new HashMap<String,String>();
        vt.add(g);
        String u;
        Queue<String> q = new ArrayDeque<String>();
        q.add(g);
        r.put(g, "");
        while (!q.isEmpty()) {
            u = q.poll();
            for (int i = 0; i < hm.get(u).size(); i++) {
                if (!vt.contains(hm.get(u).get(i))) {
                    vt.add(hm.get(u).get(i));
                    q.add(hm.get(u).get(i));
                    StringBuilder s = new StringBuilder();
                    s.append(r.get(u));
                    s.append(u.charAt(0));
                    r.put(hm.get(u).get(i), s.toString());
                    if (hm.get(u).get(i).equals(h)) {
                        vt.clear();
                        return (r.get(h)+h.charAt(0));
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l, o;
        Integer C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            if (c != 0) {
                System.out.println("");
            }
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            while (m > 0) {
                st = new StringTokenizer(br.readLine());
                o = st.nextToken();
                l = st.nextToken();
                if (hm.containsKey(o) && hm.containsKey(l)) {
                    hm.get(l).add(o);
                    hm.get(o).add(l);
                } else if ((hm.containsKey(o) && !hm.containsKey(l))) {
                    hm.get(o).add(l);
                    ArrayList<String> ala = new ArrayList<String>();
                    ala.add(o);
                    hm.put(l, ala);
                } else if ((!hm.containsKey(o) && hm.containsKey(l))) {
                    hm.get(l).add(o);
                    ArrayList<String> als = new ArrayList<String>();
                    als.add(l);
                    hm.put(o, als);
                } else {
                    ArrayList<String> alq = new ArrayList<String>();
                    alq.add(l);
                    hm.put(o, alq);
                    ArrayList<String> ald = new ArrayList<String>();
                    ald.add(o);
                    hm.put(l, ald);
                }
                m--;
            }
            while (n > 0) {
                st = new StringTokenizer(br.readLine());
                o = st.nextToken();
                l = st.nextToken();
                System.out.println(BFS(o, l));
                n--;
            }
            hm.clear();
        }
    }
}