import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] line;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        line = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            line[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            line[a].add(b);
            line[b].add(a);
        }

        visited = new boolean[N];
        boolean result = false;

        for(int i = 0; i < N; i++) {
            visited[i] = true; // 시작점 방문 표시
            if (dfs(i, 0)) {
                result = true;
                break;
            }
            visited[i] = false;
        }

        System.out.println(result ? 1 : 0);
    }

    static boolean dfs(int node, int depth){
        if(depth == 4) {
            return true;
        }

        for(int next : line[node]) {
            if(!visited[next]) {
                visited[next] = true;
                if(dfs(next, depth + 1)) {
                    return true;
                }
                visited[next] = false; // 백트래킹 시점
            }
        }
        return false;
    }
}