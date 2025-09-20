import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static boolean[] selected;
    static int minDistance = Integer.MAX_VALUE;
    
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        
        // M개의 치킨집을 선택하는 모든 조합 탐색
        selected = new boolean[chickens.size()];
        combination(0, 0);
        
        System.out.println(minDistance);
    }
    
    // 치킨집 중에서 M개를 선택하는 조합
    static void combination(int start, int count) {
        if (count == M) {
            // M개의 치킨집이 선택되면 도시의 치킨 거리 계산
            int cityDistance = calCityDistance();
            minDistance = Math.min(minDistance, cityDistance);
            return;
        }
        
        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            combination(i + 1, count + 1);
            selected[i] = false;
        }
    }
    
    static int calCityDistance() {
        int totalDistance = 0;
        
        // 각 집에 대해 가장 가까운 치킨집까지의 거리 계산
        for (Point house : houses) {
            int minChickenDistance = Integer.MAX_VALUE;
            
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point chicken = chickens.get(i);
                    int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                    minChickenDistance = Math.min(minChickenDistance, distance);
                }
            }
            
            totalDistance += minChickenDistance;
        }
        
        return totalDistance;
    }
}