import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int[][] graph;
    static int k; // 중간 거쳐가는 노드
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수 입력받기
        N = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
         * 플로이드-와샬 알고리즘 방식 적용 : 특정 노드들을 거쳐갈 수 있는 지 점진적으로 확인
         * k 는 경로의 중간 노드 역할
         * [i -> k] + [k -> j]
         * graph[출발][도착]
         */
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(graph[i][k] == 1 && graph[k][j] ==1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        // 출력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
                
    }

}