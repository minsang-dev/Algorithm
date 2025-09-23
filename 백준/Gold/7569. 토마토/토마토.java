import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0,0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        Queue<Point> q = new LinkedList<>();

        for(int k = 0; k < H; k++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    box[k][i][j] = Integer.parseInt(st.nextToken());

                    if(box[k][i][j] == 1){
                        q.add(new Point(j, i, k, 0));
                    }
                }
            }
        }
        
        int result = bfs(q);
        System.out.println(result);
    }

    static int bfs(Queue<Point> q){
        int maxDay = 0;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            maxDay = Math.max(maxDay, cur.day);

            for(int d = 0; d < 6; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) continue;

                if(box[nz][ny][nx] == 0){
                    box[nz][ny][nx] = 1;
                    q.add(new Point(nx, ny, nz, cur.day + 1));
                }
            }
        }

        for(int k = 0; k < H; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(box[k][i][j] == 0){
                        return -1;
                    }
                }
            }
        }
        return maxDay;
    }

    static class Point{
        int x;
        int y;
        int z;
        int day;

        Point(int x, int y, int z, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}