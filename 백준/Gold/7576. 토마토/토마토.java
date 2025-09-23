import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int M, N;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxDay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토 박스에 넣기
                if(box[i][j] == 1){
                    q.offer(new Point(i, j, 0));
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

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 토마토가 익지 않으면(0), 익은 상태로(-1) 변경하고, day + 1
                if(box[nx][ny] == 0){
                    box[nx][ny] = 1;
                    q.offer(new Point(nx, ny, cur.day+1));
                }
            }
        }

        // 모든 토마토가 익었는지 확인
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0){
                    // 익지 못한 토마토가 있을 경우에는 -1 출력
                    return -1;
                }
            }
        }

        return maxDay;
    }

    static class Point{
        int x;
        int y;
        int day;

        Point(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}