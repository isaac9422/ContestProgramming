package MiceAndMaze;

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
        StringBuilder sb = new StringBuilder();
        Integer C = new Integer(br.readLine());
        for(int c=0;c<C;c++){
            br.readLine();
            Integer n = new Integer(br.readLine().trim());
            Integer E = new Integer(br.readLine().trim()) - 1;
            Integer T = new Integer(br.readLine().trim());
            Integer M = new Integer(br.readLine().trim());
            N = n;
            G = new Vertex[n];
            for(int i=0;i<n;i++){
                Vertex R = new Vertex(i);
                G[i] = R;
            }
            for(int i=0;i<M;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                Integer a = new Integer(st.nextToken()) - 1;
                Integer b = new Integer(st.nextToken()) - 1;
                Integer w = new Integer(st.nextToken());
                G[a].adjacency.add(new Edge(G[b],w));
            }            
            if(c!=0){
                sb.append("\n\n");
            }
            int h = 0;
            for(int i=0;i<N;i++){
                int r = dijkstra(i, E);
                if(r<=T){
                    h++;
                }
            }
            sb.append(h);
            Arrays.fill(G,null);
        } 
        System.out.println(sb);
    }
}