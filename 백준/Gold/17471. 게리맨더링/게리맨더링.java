import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] list;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        population = new int[N + 1];
        list = new ArrayList[N + 1];
        selected = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int next = Integer.parseInt(st.nextToken());
                list[i].add(next);
            }
        }

        divide(1);

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }
    
    static void divide(int idx) {
        if (idx == N + 1) {
            ArrayList<Integer> areaA = new ArrayList<>();
            ArrayList<Integer> areaB = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i]) areaA.add(i);
                else areaB.add(i);
            }

            if (areaA.isEmpty() || areaB.isEmpty()) return;

            if (isConnected(areaA) && isConnected(areaB)) {
                int popA = getPopulation(areaA);
                int popB = getPopulation(areaB);
                minDiff = Math.min(minDiff, Math.abs(popA - popB));
            }
            return;
        }

        selected[idx] = true;
        divide(idx + 1);

        selected[idx] = false;
        divide(idx + 1);
    }

    static boolean isConnected(ArrayList<Integer> area) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(area.get(0));
        visited[area.get(0)] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : list[curr]) {
                if (area.contains(next) && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count == area.size();
    }

    static int getPopulation(ArrayList<Integer> area) {
        int total = 0;
        for (int a : area) total += population[a];
        return total;
    }
}
