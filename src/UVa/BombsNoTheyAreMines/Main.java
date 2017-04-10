package UVa.BombsNoTheyAreMines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
    public static void main(String[] args) throws IOException
 
    {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            String[] line = buf.readLine().split(" ");
            int rows = Integer.parseInt(line[0]);
            if (rows == 0)
                break;
            int columns = Integer.parseInt(line[1]);
            boolean[][] map = new boolean[rows][columns];
            int r = Integer.parseInt(buf.readLine());
            for (int i = 0; i < r; i++) {
 
                line = buf.readLine().split(" ");
                int rowNumber = Integer.parseInt(line[0]);
                int num = Integer.parseInt(line[1]);
                for (int j = 0; j < num; j++) {
                    int x = Integer.parseInt(line[j + 2]);
                    map[rowNumber][x] = true;
                }
            }
            int sX, sY;
            line = buf.readLine().split(" ");
            sY = Integer.parseInt(line[0]);
            sX = Integer.parseInt(line[1]);
            int eX, eY;
            line = buf.readLine().split(" ");
            eY = Integer.parseInt(line[0]);
            eX = Integer.parseInt(line[1]);
            int count = bfs(map, sX, sY, eX, eY);
            System.out.println(count);
        }
    }
 
    private static int bfs(boolean[][] map, int sX, int sY, int eX, int eY) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sY);
        q.add(sX);
        q.add(0);
        map[sY][sX] = true;
        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();
            int z = q.poll();
 
            if (y == eY && x == eX)
                return z;
            int[] dy = { 1, -1, 0, 0 };
            int[] dx = { 0, 0, -1, 1 };
            for (int i = 0; i < dx.length; i++) {
                if (is(map, y + dy[i], x + dx[i])) {
                    q.add(y + dy[i]);
                    q.add(x + dx[i]);
                    q.add(z + 1);
 
                }
            }
        }
 
        return -1;
    }
 
    private static boolean is(boolean[][] map, int i, int j) {
 
        if ( i < 0 || j < 0 || i >= map.length
                || j >= map[0].length||map[i][j] )
            return false;
        else {
            map[i][j] = true;
            return true;
        }
    }
 
}