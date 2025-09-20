import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int time = 0;
        
        while (hasChesse()) {
            visited = new boolean[N][M];
            markOutsideAir(0, 0);
            
            List<Point> cheeseToMelt = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        int contactCount = countOutsideAirContact(i, j);
                        if (contactCount >= 2) {
                            cheeseToMelt.add(new Point(i, j));
                        }
                    }
                }
            }
            
            for (Point p : cheeseToMelt) {
                map[p.x][p.y] = 0;
            }
            
            time++;
        }
        
        System.out.println(time);
    }
    
    static void markOutsideAir(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    markOutsideAir(nx, ny);
                }
            }
        }
    }
    
    static int countOutsideAirContact(int x, int y) {
        int count = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == 0 && visited[nx][ny]) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static boolean hasChesse() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}