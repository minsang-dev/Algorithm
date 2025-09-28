import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxDistance = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(maxDistance);
    }
    
    static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        int[][] distance = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        
        queue.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;
        
        int currentMaxDistance = 0;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            currentMaxDistance = Math.max(currentMaxDistance, current.dist);
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, current.dist + 1));
                }
            }
        }
        
        maxDistance = Math.max(maxDistance, currentMaxDistance);
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    static class Point {
        int x, y, dist;
        
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

class OptimizedSolution {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxDistance = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfsOptimized(i, j);
                }
            }
        }
        
        System.out.println(maxDistance);
    }
    
    static void bfsOptimized(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        queue.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;
        
        int currentMaxDistance = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            currentMaxDistance = Math.max(currentMaxDistance, dist[x][y]);
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (isValid(nx, ny) && dist[nx][ny] == -1 && map[nx][ny] == 'L') {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        maxDistance = Math.max(maxDistance, currentMaxDistance);
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}