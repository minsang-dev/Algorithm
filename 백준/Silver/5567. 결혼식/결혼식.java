import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int n, m;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 연관관계 -> 양방향 그래프
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        // 방문 배열 초기화 (1번 노드부터)
        visited = new boolean[n+1];

        // 가까운 노드부터 탐색하기 위해 bfs 사용
        bfs();
        
        int ans = 0;
        for(int i = 2; i <=n; i++){ // 2번 노드부터 n까지
            if(visited[i]){
                ans++;
            }
        }
        System.out.println(ans);

    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 1번 노드부터 시작
        visited[1] = true;

        int[] depth = new int[n+1]; // 노드 깊이 초기화
        depth[1] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(depth[cur] == 2)
            continue;

            // 인접한 모든 리스트 순회
            for(int next: list.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}