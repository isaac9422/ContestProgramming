package SendingEmail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Vertex[] G;
    static final int INF = Integer.MAX_VALUE;

    static class Vertex {

        int id;
        List< Edge> adjacency = new ArrayList< Edge>();

        public Vertex(int id) {
            this.id = id;
        }
    }

    static class Edge {

        Vertex to;
        int weight;

        public Edge(Vertex to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class QueueItem implements Comparable< QueueItem> {

        Vertex v;
        int distance;

        public QueueItem(Vertex v, int distance) {
            this.v = v;
            this.distance = distance;
        }

        public int compareTo(QueueItem q) {
            return this.distance - q.distance;
        }
    }

    static int dijkstra(int s, int t) {
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        PriorityQueue< QueueItem> Q = new PriorityQueue< QueueItem>();
        Arrays.fill(distance, INF);
        distance[s] = 0;
        Q.offer(new QueueItem(G[s], 0));
        while (!Q.isEmpty()) {
            QueueItem q = Q.poll();
            Vertex v = q.v;
            if (!visited[v.id]) {
                visited[v.id] = true;

                for (Edge edge : G[v.id].adjacency) {
                    Vertex w = edge.to;
                    int weight = edge.weight;
                    if (distance[w.id] > distance[v.id] + weight) {
                        distance[w.id] = distance[v.id] + weight;
                        Q.offer(new QueueItem(w, distance[ w.id]));
                    }
                }
            }
        }
        return distance[t];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer C = new Integer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < C; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer n = new Integer(st.nextToken());
            Integer m = new Integer(st.nextToken());
            Integer S = new Integer(st.nextToken());
            Integer T = new Integer(st.nextToken());
            N = n;
            G = new Vertex[n];
            for (int i = 0; i < n; i++) {
                Vertex R = new Vertex(i);
                G[i] = R;
            }
            for (int i = 0; i < m; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int a = Integer.valueOf(stk.nextToken());
                int b = Integer.valueOf(stk.nextToken());
                int w = Integer.valueOf(stk.nextToken());
                G[a].adjacency.add(new Edge(G[b],w));
                G[b].adjacency.add(new Edge(G[a],w));
            }
            int r = dijkstra(S, T);
            if (r == INF) {
                sb.append("Case #" + (c + 1) + ": unreachable");
            } else {
                sb.append("Case #" + (c + 1) + ": " + r);
            }
            sb.append("\n");
            Arrays.fill(G, null);
        }
        System.out.print(sb);
    }
}