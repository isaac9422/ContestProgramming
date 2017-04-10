/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google.CodeJam17.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * @author jhunior
 */
public class C {

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int x = 1; x <= T; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Integer.parseInt(st.nextToken());
            long y = 0, z = 0;
            List<Long> al = new ArrayList<>();
            for (long i = 1; i <= n; i++) {
                al.add(i);
            }
            PriorityQueue<ListStall> pq = new PriorityQueue();
            pq.add(new ListStall(n, al));
            for (int i = 0; i < k; i++) {
                ListStall stallList = pq.poll();
                n = stallList.lista.size();
                ListStall first = null;
                ListStall last = null;
                if (n % 2 == 0) {
                    try {
                        first = new ListStall((n / 2) - 1, stallList.lista.subList(0, (n / 2) - 1));
                    } catch (Exception e) {
                        if (n / 2 - 1 >= 0) {
                            first = new ListStall((n / 2) - 1, new ArrayList());
                        } else {
                            first = new ListStall(0, new ArrayList());
                        }
                    }
                    try {
                        last = new ListStall((n / 2), stallList.lista.subList(n / 2, n));
                    } catch (Exception e) {
                        if (n / 2 - 1 >= 0) {
                            last = new ListStall((n / 2) - 1, new ArrayList());
                        } else {
                            last = new ListStall(0, new ArrayList());
                        }
                    }
                } else {
                    try {
                        first = new ListStall(n / 2, stallList.lista.subList(0, n / 2));
                    } catch (Exception e) {
                        if (n / 2 - 1 >= 0) {
                            first = new ListStall((n / 2) - 1, new ArrayList());
                        } else {
                            first = new ListStall(0, new ArrayList());
                        }
                    }
                    try {
                        last = new ListStall((n / 2), stallList.lista.subList((n / 2) + 1, n));
                    } catch (Exception e) {
                        if (n / 2 - 1 >= 0) {
                            last = new ListStall((n / 2) - 1, new ArrayList());
                        } else {
                            last = new ListStall(0, new ArrayList());
                        }
                    }
                }
                if (i == (k - 1)) {
                    y = Math.max(first.tamano, last.tamano);
                    z = Math.min(first.tamano, last.tamano);
                    break;
                }
                pq.add(first);
                pq.add(last);
            }
            System.out.println("Case #" + x + ": " + y + " " + z);
        }
    }

}

class ListStall implements Comparable<ListStall> {

    long tamano;
    List<Long> lista;

    ListStall(long n, List al) {
        this.tamano = n;
        this.lista = al;
    }

    @Override
    public int compareTo(ListStall o) {
        if (this.tamano > o.tamano) {
            return -1;
        } else if (this.tamano < o.tamano) {
            return 1;
        } else {
            if(this.lista.size()==0){
               return 1; 
            }else if(o.lista.size() == 0){
                return -1;
            }else if (this.lista.get(0) > o.lista.get(0)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
