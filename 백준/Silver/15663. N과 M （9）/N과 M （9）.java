import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        used = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtrack(0);
        System.out.print(sb.toString());
    }

    static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]);
                if (i < M - 1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;

            if (arr[i] == prev) continue;

            prev = arr[i];
            used[i] = true;
            result[depth] = arr[i];

            backtrack(depth + 1);

            used[i] = false;
        }
    }
}