import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int V, E, K;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.get(u).add(new Edge(v, w));
        }

        int[] dist = dij(edges, K, V);

        for(int i = 1; i <= V; i++){
            if(dist[i] == INF){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static int[] dij(ArrayList<ArrayList<Edge>> edges, int start, int V){
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[V+1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;

            if(visited[now]) continue;
            visited[now] = true;

            for(Edge e : edges.get(now)){
                int newTo = e.to;
                int newCost = e.cost;

                if(dist[newTo] > dist[now] + newCost){
                    dist[newTo] = dist[now] + newCost;
                    pq.offer(new Edge(newTo, dist[newTo]));
                }
            }
        }

        return dist;
    }


    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }
    }
}