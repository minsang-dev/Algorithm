import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution{
    static int N;
    // 8방 탐색
    static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int[] dy = {1, 0, -1, 1, 0, -1, -1, 1};
    static char[][] map;
    static int[][] count;
    static boolean[][] visited;

    // 지뢰 : o -> *, 지뢰 x -> . , 클릭한 지뢰 x -> c 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
        StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            map = new char[N][N];
            count = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                String line = br.readLine();
                map[i] = line.toCharArray();
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == '*'){ // 지뢰 칸
                        count[i][j] = -1;
                        continue;
                    }
                    int minClick = 0;
                    for(int d = 0; d < 8; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == '*'){
                            minClick++;
                        }
                    }
                    count[i][j] = minClick;
                }
            }

            int clicks = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(count[i][j] == 0 && !visited[i][j]){
                        bfs(new Node(i, j));
                        clicks++;
                    }
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(count[i][j] >= 0 && !visited[i][j]){
                        clicks++;
                    }
                }
            }

            System.out.println("#" + tc + " " + clicks);
        }
    }

    static void bfs(Node start){
        Queue<Node> q = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        q.offer(start);

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(count[cur.x][cur.y] != 0) continue;

            for(int d= 0; d < 8; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(!isIN(nx, ny))   continue; // 맵 범위 밖
                if(visited[nx][ny]) continue; // 이미 방문한 칸
                if(count[nx][ny] == -1)    continue; // 폭탄이 있는 곳

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }
        static boolean isIN(int x, int y){
            return x >=0 && y >= 0 && x < N && y < N;
    }
}

class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}