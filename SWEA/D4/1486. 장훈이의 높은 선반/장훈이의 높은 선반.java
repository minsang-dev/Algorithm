import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, B;
    static int[] H;
    static int gapMin;
    static int tc;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc < T+1; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            gapMin = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            // 배열 초기화
            H = new int[N];
            for(int i = 0; i < N; i++){
                H[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println("#" + (tc) + " " + gapMin);
        }

        
    }

    static void dfs(int idx, int sum){
        if(idx == N){
            if(sum >= B){
                gapMin = Math.min(sum-B, gapMin);
            }
            return;
        }
        if(sum-B >= gapMin)
        return;

    dfs(idx+1, sum+H[idx]);
    dfs(idx+1, sum);

    }    
}