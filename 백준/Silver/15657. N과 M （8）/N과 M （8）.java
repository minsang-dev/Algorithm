import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int N, M;
    static int[] arr;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0,0);
        System.out.println(sb);
    }

    static void dfs(int start, int depth){
        if(depth == M){
            for(int i=0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            arr[depth] = num[i];
            dfs(i, depth+1);
        }
    }
}