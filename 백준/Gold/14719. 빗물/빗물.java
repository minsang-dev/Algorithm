import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int H, W;
    static int[] height;
    // 구하고자 하는 것 : 빗물의 총량

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        height = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 양쪽 기둥의 최대 높이 구하기 위해서
        // mid 기준으로 앞 : 0 ~ mid -1, mid +1 ~ W-1 
        int result = 0;
        for(int i = 0; i < W; i++) {
            // 왼쪽 최대높이부터 구하기
            int leftMax = 0;
            for(int j = i-1; j >= 0; j--){
                if(height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            // 오른쪽 최대 높이
            int rightMax = 0;
            for(int j = i+1; j < W; j++) {
                if(height[j] > rightMax) {
                    rightMax = height[j];
                }
            }

            // 빗물의 양 채우기
            int smaller = Math.min(leftMax, rightMax);
            
            if(smaller > height[i]){
            result += smaller - height[i];
            }
        }
        System.out.println(result);
    }
}