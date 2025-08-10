import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int TC, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TC = Integer.parseInt(st.nextToken());

        for(int t = 0; t < TC; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for(int i =0; i < N; i++){
                String line = br.readLine();
                for(int j = 0; j < N; j++){
                    arr[i][j] = line.charAt(j) - '0';
                }
            }
            M = N/2;
            int sum = 0;
            for(int i = 0; i < M+1; i++){
                for(int j = M-i; j <= M+i; j++){
                    sum += arr[i][j];
                }
            }

            for(int i = M-1; i >=0; i--){
                for(int j = M-i; j <= M+i; j++){
                    sum += arr[N-1-i][j];
                }
            }
            System.out.println("#" + (t+1) + " " + sum);
        }
    }
}
