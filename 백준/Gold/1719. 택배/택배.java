import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static ArrayList<Point>[] graph;
    static int[][] result;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        result = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
            
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

        graph[start].add(new Point(end, weight));
        graph[end].add(new Point(start, weight));

        }
        
        for(int i = 1; i <= n; i++){
            dij(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) {
                    sb.append("- ");
            } else {
                sb.append(result[i][j]).append(" ");
            }
        }
        sb.append("\n");
    }

    System.out.println(sb.toString());;
}

        static void dij(int start){
            int[] dist = new int[n+1];
            Arrays.fill(dist, INF);
            dist[start] = 0;
            
            PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
            pq.add(new Point(start, 0));

            while(!pq.isEmpty()){
                Point cur = pq.poll();

                int now = cur.to;
                int newCost = cur.cost;

                if(newCost > dist[now]) continue;

                for(Point p : graph[now]){
                    int nextTo = p.to;
                    int nextCost = dist[now] + p.cost;

                    if(nextCost < dist[nextTo]){
                        dist[nextTo] = nextCost;
                        
                        if(now == start){
                            result[start][nextTo] = nextTo;
                        } else {
                            result[start][nextTo] = result[start][now];
                        }
                        
                        pq.add(new Point(nextTo, nextCost));
                }
            }
        }
    }

    static class Point{
        int to;
        int cost;

        Point(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}
