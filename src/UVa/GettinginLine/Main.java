package UVa.GettinginLine;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class GettinInLine {

    static int n;
    static Point point[];
    static double distance[][];
    static double min;
    static String path;
    static boolean visited[];
    static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    public static void TSP(int pos, double total, String ruta) {
        //System.out.println(ruta);
        if (ruta.length() == n) {
            if (min > total) {
                path = ruta;
                min = total;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i] == true && i != pos) {
                    continue;
                }
                visited[i] = true;
                TSP(i, total + distance[pos][i], ruta + (Integer.valueOf(i).toString()));
                visited[i] = false;
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;
        int c = 1;
        while (true) {
            n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) {
                break;
            }
            point = new Point[n];
            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                point[i] = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            }
            distance = new double[n][n];
            visited = new boolean[n];
            path = "";
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    distance[i][j] = point[i].distance(point[j]);
                    if (i != j) {
                        distance[i][j] += 16.0;
                    }
                }
            }
            visited[0] = true;
            TSP(0,0.0,"0");
            /*for (int i = 0; i < n - 1; i++) {
                stringBuilder.append("Cable requirement to connect ").append(pointToString(point[path.charAt(i)-'0'])).append(" to ").append(pointToString(point[path.charAt(i+1)-'0'])).append(" is ").append(FORMAT.format(distance[path.charAt(i)-'0'][path.charAt(i+1)-'0'])).append(" feet.\n");
            }*/

            stringBuilder.append("Number of feet of cable required is ").append(FORMAT.format(min)).append(".\n");
        }
        System.out.print(stringBuilder);
    }

    public static String pointToString(Point p) {
        StringBuilder st = new StringBuilder();
        st.append('(').append(p.x);
        st.append(',');
        st.append(' ').append(p.y).append(')');
        return st.toString();
    }
}
