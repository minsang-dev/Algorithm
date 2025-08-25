import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
    static int T;
    static int D, W, K;
    static int[][] film;
    static int Min; // 최소 투입 횟수
    static int[] chemicals; // 약품 투약 정보

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <=T; tc++){
            st = new StringTokenizer(br.readLine());
            
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            Min = Integer.MAX_VALUE;
            chemicals = new int[D];

            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);
            System.out.println("#" + tc + " " + Min);
        }
        
    }

    // dfs 메서드 - 약품 처리 상황
    static void dfs(int inputCnt, int idx){
        if(inputCnt > K){
            return;
        }
        if(inputCnt >= Min){
            return;
        }

        if(idx == D){
            if(check()){
                Min = Math.min(Min, inputCnt);
            }
            return;
        }
        // 약품 미투입, 약품 투입(A(0), B(1))
        for(int i = -1; i < 2; i++){
            chemicals[idx] = i;
            if(i == -1){
                dfs(inputCnt, idx+1);
            } else {
                dfs(inputCnt+1, idx+1);
            }
        }
    }

    // 방문 체크
    static boolean check(){
        int cnt = 0;
        int cur, next;
        for(int col = 0; col < W; col++){
            cnt = 1;

            for(int row = 0; row < D-1; row++){
                // 약품 투여 여부 확인
                if(chemicals[row] == -1){
                    cur = film[row][col];
                } else {
                    cur = chemicals[row];
                }

                if(chemicals[row+1] == -1){
                    next = film[row+1][col];
                } else {
                    next = chemicals[row+1];
                }
                
                if(cur == next){
                    cnt++;
                    if(cnt >= K){
                        break;
                    }
                } else {
                    // 연속 끊기면 다시 1부터
                    cnt = 1;
                }
            }
            if(cnt < K){
                return false;
            }
        }
        return true;
    }
}