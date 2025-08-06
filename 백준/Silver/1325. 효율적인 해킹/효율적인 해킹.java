import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int N, M;
    static ArrayList <Integer>[] arr;
    static boolean visited[];
    static int max;
    static int cnt[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N+1];
        arr = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
        }

        for(int i = 1; i < N+1; i++){
            visited = new boolean[N+1];
            cnt[i] = BFS(i); // 각 시작점마다 해킹 가능한 컴퓨터 수 저장
        }

        max = 0;
        for (int  i= 1; i< N+1; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N+1; i++){
            if(cnt[i] == max){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i : arr[cur]){
                if(!visited[i]){ // 방문하지 않은 노드만 처리
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        return count;
    }
}