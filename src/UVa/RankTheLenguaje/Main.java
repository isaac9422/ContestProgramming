package UVa.RankTheLenguaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Collections;
 
public class Main {
 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] m;
 
    public static void DFS(int i, int j, char k) {
        if (m[i][j] == '.' || m[i][j] != k) {
        } else {
            m[i][j] = '.';
            for (int l = 0; l < 4; l++) {
                if (isValid(i + dx[l], j + dy[l])) {
                    DFS(i + dx[l], j + dy[l], k);
                }
            }
        }
    }
 
    public static boolean isValid(int r, int t) {
        return r >= 0 && t >= 0 && t < m[0].length && r < m.length;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        Integer N = new Integer(br.readLine());
        for (int c = 0; c < N; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer H = new Integer(st.nextToken());
            Integer W = new Integer(st.nextToken());
            m = new char[H][W];
            for (int i = 0; i < H; i++) {
                m[i] = br.readLine().toCharArray();
            }
            HashMap<Character, Integer> hm = new HashMap();
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    char k = m[i][j];
                    if (k == '.') {
                        continue;
                    } else {
                        DFS(i, j, k);
                        if (hm.containsKey(k)) {
                            Integer y = hm.get(k);
                            y++;
                            hm.put(k, y);
                        } else {
                            hm.put(k, 1);
                        }
                    }
                }
            }
            Integer[] arr = new Integer[hm.size()];
            ArrayList<Character> al = new ArrayList();
            int p = 0;
            for (Iterator it = hm.keySet().iterator(); it.hasNext();) {
                Character e = (Character) it.next();
                al.add(e);
                arr[p] = hm.get(e);
                p++;
            }
            Arrays.sort(arr);
                Collections.sort(al);
            sb.append("World #" + (c + 1)+"\n");
            do {
                for (Iterator it = al.iterator(); it.hasNext();) {
                    Character e = (Character) it.next();
                    if (hm.get(e) == arr[p-1]) {
                        sb.append(e + ": " + hm.get(e)+"\n");
                        hm.remove(e);
                        p--;
                        break;
                    }
                }
            } while (!hm.isEmpty()); 
        }
        System.out.print(sb);
    }
}