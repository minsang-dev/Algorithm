import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int N;
    static ArrayList<Integer>[] LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        LIS = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            LIS[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            LIS[i].add(num);
        }

        ArrayList<Integer> length = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            int num = LIS[i].get(0);

            if(length.isEmpty() || length.get(length.size()-1) < num){
                length.add(num);
            } else {
                int left = 0;
                int right = length.size() - 1;

                while(left < right){
                    int mid = (left + right) / 2;

                    if(length.get(mid) >= num){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                length.set(right, num);
            }
        }

        System.out.println(length.size());
    }

}