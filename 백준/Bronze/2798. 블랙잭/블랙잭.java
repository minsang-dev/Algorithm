import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N, M;
    static int gapMax = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        System.out.println(gapMax);
    }


    static void dfs(int depth, int start, int sum){
        if(depth == 3){
            if(sum <= M){
                gapMax = Math.max(gapMax, sum);
            }
            return;    
        }
        for(int i = start; i < N; i++){
        dfs(depth+1, i+1, sum + arr[i]);
            }    
        
    }
}