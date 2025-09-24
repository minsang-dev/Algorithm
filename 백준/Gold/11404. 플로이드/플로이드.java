import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int n, m;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];

        // 모든 거리를 무한대로 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = INF;
                }
            }
        }

        for(int i = 1; i <= m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);

        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                if(dist[i][k] != INF && dist[k][j] != INF){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(dist[i][j] == INF){
                sb.append("0 ");
            } else {
                sb.append(dist[i][j] + " ");
            }
        }
        sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}