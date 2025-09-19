import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 0; i < N; i++){ // sum은 반복문 안에서만 사용하는 합
            int sum = A[i]; // sum을 전역변수로 선언하지 않기 !!
            if(sum == M){
                answer++;
                continue;
            }

            for(int j = i+1; j < N; j++){
                sum += A[j];
                if(sum == M){
                    answer++;
                    break;
                }

                else if(sum > M){
                    break;
                }
            }
        }
        System.out.print(answer);

    }
}