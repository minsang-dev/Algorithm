import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    static int N, C;
    static int[] arr;
    static ArrayList<Long> leftSums, rightSums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mid = N / 2;

        leftSums = new ArrayList<>();
        rightSums = new ArrayList<>();

        generateSums(1, mid+1, 0, leftSums);
        generateSums(mid+1, N+1, 0, rightSums);

        Collections.sort(rightSums);

        long ans = 0;

        for(long leftSum : leftSums){
            if(leftSum > C) continue;

            long remaining = C - leftSum;

            ans += upperBound(rightSums, remaining);
        }

        System.out.println(ans);
    }

    static void generateSums(int start, int end, long curSum, ArrayList<Long>sums){
        if(start == end){
            sums.add(curSum);
            return;
        }

        generateSums(start+1, end, curSum, sums);

        if(curSum + arr[start] <= C){
            generateSums(start+1, end, curSum+arr[start], sums);
        }
    }

    static int upperBound(ArrayList<Long> list, long target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;
            if (list.get(mid) <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}