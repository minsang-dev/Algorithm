import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    
    static int N;    // 7 ≤ N ≤ 12
    static int[][] map;
    static int min_length, max_connected;
    static ArrayList<Point> maxinos;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            
            map = new int[N][N];
            maxinos = new ArrayList<Point>();
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1){
                        if (i == 0 || i == N-1 || j == 0 || j == N-1)  continue;
                    else {
                        maxinos.add(new Point(i, j, false));
                    }
                }
            }
        }
            
            // 전선 길이 합 -> 최소
            min_length = Integer.MAX_VALUE;
            // 최대한 많은 core에 연결
            max_connected = 0;
            
            dfs(0);
            
            System.out.println("#" + tc + " " + min_length);
        }
    }
    
    // 연결되면 연결된 개수 ++
    static void dfs(int index) {
        if(index == maxinos.size()) {
            int connected_cnt = 0;
            for(Point p : maxinos) {
                if(p.connected == true) {
                    connected_cnt++;
            }
        }
            
            // 연결된 개수 > 최대한 많이 연결된 개수 -> 개수 갱신
            if(connected_cnt > max_connected) {
                max_connected = connected_cnt;
                min_length = wire_length();
            } else if(connected_cnt == max_connected) {
                min_length = Math.min(min_length, wire_length());
            }
            return;
        }
        Point cur = maxinos.get(index);

        // 여기서 백트래킹 (상하좌우 방향으로) 돌아야함
        for(int d = 0; d < 4; d++) {
            if(can_place_wire(cur.y, cur.x, d)) {
                place_wire(cur.y, cur.x, d, 2);
                cur.connected = true;
                
                dfs(index+1);
                
                place_wire(cur.y, cur.x, d, 0);
                cur.connected = false;
                
            }
        }
        // 전선을 연결하지 않는 경우
        cur.connected = false;
        dfs(index+1);

    }
    
    static boolean can_place_wire(int y, int x, int dir) {
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        while(isIn(ny, nx)) {
            if(map[ny][nx] != 0) {
                return false;
            }
            ny += dy[dir];
            nx += dx[dir];
        }
        
        return true;
    }
    
    static void place_wire(int y, int x, int dir, int value) {
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        while(isIn(ny, nx)) {
            map[ny][nx] = value;
            ny += dy[dir];
            nx += dx[dir];
        }
        
    }
    
    static int wire_length() {
        int length = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 2) {
                    length++;
                }
            }
        }
        return length;
    }
    
    static boolean isIn(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
    
    static class Point{
        int y;
        int x;
        boolean connected;
        
        public Point(int y, int x, boolean connected) {
            super();
            this.y = y;
            this.x = x;
            this.connected = connected;
        }

    }

}